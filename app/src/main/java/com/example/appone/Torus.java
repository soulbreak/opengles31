package com.example.appone;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.util.Log;

public class Torus {

    private List<String> verticesList;
    private List<String> facesList;

    public Torus(Context context) {
        verticesList = new ArrayList<>();
        facesList = new ArrayList<>();
    }

    public void build(Context context) {
        AssetManager am = context.getAssets();
        Log.i("Torus", "Creation");
        Scanner scanner = null;
        try {

            InputStream is = am.open("torus.obj");
            scanner = new Scanner(is);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Log.d("Torus", "Parsing " + line);
                if (line.startsWith("v ")) {
                    // Add vertex line to list of vertices
                    verticesList.add(line);
                } else if (line.startsWith("f ")) {
                    // Add face line to faces list
                    facesList.add(line);
                }
            }
            scanner.close();
        } catch (IOException io) {
            Log.e("Torus", "Torus cannot be opened" + io);
        } finally {

        }
    }
}


