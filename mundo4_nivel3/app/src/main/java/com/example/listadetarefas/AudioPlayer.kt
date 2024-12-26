package com.example.listadetarefas

import android.content.Context
import android.media.MediaPlayer

class AudioPlayer(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    // Iniciar a reprodução de áudio
    fun playAudio() {
        // Se houver uma reprodução ativa, pare antes de iniciar outra
        stopAudio()

        // Carregar o som da pasta raw
        mediaPlayer = MediaPlayer.create(context, R.raw.alert_sound)
        mediaPlayer?.start()
    }

    // Parar a reprodução de áudio
    fun stopAudio() {
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
                release()
            }
        }
        mediaPlayer = null
    }
}
