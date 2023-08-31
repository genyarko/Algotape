package com.example.algotapez.ui.dashboard;

import static android.app.Activity.RESULT_OK;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.algotapez.databinding.FragmentDashboardBinding;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class DashboardFragment extends Fragment {

    private ProgressDialog progressDialog;
    private static final int PICK_IMAGE_REQUEST_CODE = 1;
    private static final int PICK_AUDIO_REQUEST_CODE = 2;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private FragmentDashboardBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setupViewModel();
        initializeViews();

        return binding.getRoot();
    }

    private void setupViewModel() {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    private void initializeViews() {
        setupProgressDialog();
        hideActionBar();

        binding.musicImage.setOnClickListener(view -> launchImagePicker());
        binding.chooseMusicBtn.setOnClickListener(view -> launchAudioPicker());
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Uploading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
    }

    private void hideActionBar() {
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void launchImagePicker() {
        startActivityForResult(createFilePickerIntent("image/*"), PICK_IMAGE_REQUEST_CODE);
    }

    private void launchAudioPicker() {
        startActivityForResult(createFilePickerIntent("audio/*"), PICK_AUDIO_REQUEST_CODE);
    }

    private Intent createFilePickerIntent(String type) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(type);
        return intent;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == PICK_IMAGE_REQUEST_CODE) {
                handleFileUpload(data.getData(), "images/");
            } else if (requestCode == PICK_AUDIO_REQUEST_CODE) {
                handleFileUpload(data.getData(), "audio/");
            }
        }
    }

    private void handleFileUpload(Uri selectedFileUri, String storagePath) {
        uploadFileToFirebase(selectedFileUri, storagePath);
    }

    private void uploadFileToFirebase(Uri fileUri, String storagePath) {
        progressDialog.show();
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference fileRef = storageRef.child(storagePath + fileUri.getLastPathSegment());

        fileRef.putFile(fileUri)
                .addOnSuccessListener(taskSnapshot -> {
                    getFileDownloadUrl(fileRef);
                })
                .addOnFailureListener(e -> {
                    progressDialog.dismiss();
                    // Handle upload failure
                });
    }

    private void getFileDownloadUrl(StorageReference fileRef) {
        fileRef.getDownloadUrl().addOnSuccessListener(downloadUri -> {
            String fileUrl = downloadUri.toString();
            // Associate the URL with your music entry
            progressDialog.dismiss();
            clearInputFields();
        });
    }

    private void clearInputFields() {
        binding.musicTitleEt.setText("");
        binding.musicArtistEt.setText("");
        binding.musicProducerEt.setText("");
        binding.musicInstrumentalistEt.setText("");
        binding.musicLabelEt.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
