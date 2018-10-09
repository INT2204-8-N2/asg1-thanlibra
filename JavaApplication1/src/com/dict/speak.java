/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dict;

/**
 *
 * @author Lai Thi Thu Phuong
 */
import com.sun.speech.freetts.VoiceManager; // cái này phải tải thư viện freetts về và import vào //project.

public class speak {
    public void speech(String text) {
        VoiceManager voiceManager = VoiceManager.getInstance();
        com.sun.speech.freetts.Voice syntheticVoice = voiceManager.getVoice("kevin16");
        syntheticVoice.allocate();
        syntheticVoice.speak(text);
        syntheticVoice.deallocate();
    }
    public static void main(String[] args) {
        
    }
}
