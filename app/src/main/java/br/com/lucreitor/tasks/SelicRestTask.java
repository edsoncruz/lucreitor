package br.com.lucreitor.tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.com.lucreitor.vo.Selic;

public class SelicRestTask extends AsyncTask<Void, Void, Selic[]> {

    @Override
    protected Selic[] doInBackground(Void... params) {
        try {
            final String url = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.1178/dados/ultimos/1?formato=json";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Selic[] selicList = restTemplate.getForObject(url, Selic[].class);
            return selicList;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Selic[] selicList) {
        Log.i("Log",selicList[0].getData());
        Log.i("Log",selicList[0].getValor());
    }
}
