package com.example.listadetarefas

import android.content.Context
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.media.AudioDeviceCallback
import android.media.AudioManager.GET_DEVICES_OUTPUTS
import android.content.pm.PackageManager
import android.util.Log

class AudioHelper(private val context: Context) {

    private val audioManager: AudioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    // Verifica se a saída de áudio está disponível
    fun audioOutputAvailable(type: Int): Boolean {
        if (!context.packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)) {
            return false
        }

        return audioManager.getDevices(GET_DEVICES_OUTPUTS).any { it.type == type }
    }

    // Callback para mudanças nos dispositivos de áudio
    fun registerAudioDeviceCallback() {
        audioManager.registerAudioDeviceCallback(object : AudioDeviceCallback() {

            // Dispositivo Conectado
            override fun onAudioDevicesAdded(addedDevices: Array<out AudioDeviceInfo>?) {
                addedDevices?.forEach {
                    Log.d("AudioCallback", "Dispositivo conectado: ${it.type}")
                }
            }

            // Dispositivo Desconectado
            override fun onAudioDevicesRemoved(removedDevices: Array<out AudioDeviceInfo>?) {
                removedDevices?.forEach {
                    Log.d("AudioCallback", "Dispositivo desconectado: ${it.type}")
                }
            }

        }, null)
    }
}
