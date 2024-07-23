package com.example.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.permisionBtn.setOnClickListener {
            checkBackgroundLocationPermission.launch(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
    }


    val checkBackgroundLocationPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        if(it){
            Log.d("RequestPermission","Background location permission granted")
        }else{
            Log.d("RequestPermission","Background location permission denied")

        }
    }
//    private fun hasWriteExternalStoragePermission()=
//       ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
//    private fun hasForegroundLocationPermission()=
//        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED
//    private fun hasBackgroundLocationPermission()=
//        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION)==PackageManager.PERMISSION_GRANTED
//
//    private fun requestPermission(){
//
//        val permissionList = mutableListOf<String>()
//
//        //check if android version is greater than equal to Q/android 10
//
//        if(!hasWriteExternalStoragePermission()){
//            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        }
//
//        if(!hasForegroundLocationPermission()){
//            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION)
//        }
//
//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.Q){
//
//            if(!hasBackgroundLocationPermission()){
//                permissionList.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
//            }
//        }
//        Log.d("RequestPermission","permission list $permissionList")
//        if(permissionList.isNotEmpty()){
//            Log.d("RequestPermission","$permissionList")
//            ActivityCompat.requestPermissions(this,permissionList.toTypedArray(),0)
//        }
//        else{
//            Log.d("RequestPermission","all permission granted")
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if(requestCode==0){
//            for(i in permissions.indices){
//                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
//                    Log.d("RequestPermission","${permissions[i]} granted.")
//                }else{
//                    Log.d("RequestPermission","${permissions[i]} denied.")
//
//                }
//            }
//        }
//    }
}