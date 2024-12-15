package com.example.virtualpet;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLogic {
    private Pet pet;
    private UIManager uiManager;
    private Timeline timer;

    public GameLogic(Pet pet, UIManager uiManager) {
        this.pet = pet;
        this.uiManager = uiManager;
        setupTimer();
    }

    private void setupTimer() {
        // Periodically decrease the pet's stats (energy, hunger, happiness)
        timer = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
            pet.decayStats();
            updateUI(); // Update UI to reflect the new stats
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void updateUI() {
        // Assuming UIManager has methods to update progress bars
        uiManager.updateEnergyBar(pet.getEnergy());
        uiManager.updateHungerBar(pet.getHunger());
        uiManager.updateHappinessBar(pet.getHappiness());
    }
}

