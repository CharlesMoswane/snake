import brain.NeuralNetwork;
import brain.NeuralNetworkTrainer;
import data.ModelPersistenceManager;
import data.PositionPersistenceManager;
import game.Game;

import java.io.File;
import java.sql.Timestamp;
import java.util.Timer;

public class Main {

    public static void main(String[] args){
        startTraining();
        Game game = new Game();
        game.start();
    }

    private static void startTraining() {
        File dir = new File("C:\\Users\\cmosw\\Desktop\\OneDrive\\My Documents\\8. Creation" +
                "\\1. My Projects\\1. AI\\1. Snake\\1. Data\\models\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        PositionPersistenceManager positionPersistenceManager = new PositionPersistenceManager(dir.getAbsolutePath());
        ModelPersistenceManager modelPersistenceManager = new ModelPersistenceManager();
//        modelPersistenceManager.saveModelToJsonFile(brain, dir + "\\model.json");
        NeuralNetwork brain = modelPersistenceManager.loadModelFromJsonFile(dir + "\\trained-model.json");
        NeuralNetworkTrainer neuralNetworkTrainer = new NeuralNetworkTrainer(brain, positionPersistenceManager);
        System.out.println("Training neural network...");

        long startTime = System.currentTimeMillis();
        neuralNetworkTrainer.train("C:\\Users\\cmosw\\Desktop\\OneDrive\\My Documents\\8. Creation\\1. My Projects\\1. AI\\1. Snake\\1. Data\\keylog.json");
        long endTime = System.currentTimeMillis();

        System.out.println("Training started at: " + new Timestamp(startTime));
        System.out.println("Training ended at: " + new Timestamp(endTime));
        System.out.println("Training duration: " + (endTime - startTime) + " milliseconds");
    }
}
