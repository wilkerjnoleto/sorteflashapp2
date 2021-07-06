package com.sorteflash.sorteflashapp;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RotaLogin {

    public void logar(String login,String senha) {

        try {
            String url = "http://13.59.51.94:5000/api/auth/login";
            URL body = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) body.openConnection();
            urlConnection.setRequestMethod("GET");
            //urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            StringBuilder buffer = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String teste = buffer.toString();
            System.out.println(teste);
            JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(buffer.toString().replaceAll(Pattern.quote("["), "").replaceAll("]", ""));
        }catch (MalformedURLException ex) {
            Logger.getLogger(RotaLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RotaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (ParseException e) {
            e.printStackTrace();
        }



    }




    public static void main(String args[]) {
        RotaLogin login = new RotaLogin();

        login.logar("teste","teste");




    }

}
