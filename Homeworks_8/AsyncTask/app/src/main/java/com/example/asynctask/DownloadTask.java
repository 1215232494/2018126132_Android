package com.example.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

    Context context;
    ProgressDialog progressDialog = new ProgressDialog(context);
    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            int downloadPercent = 0;
            while(true){
                downloadPercent = doDownload(downloadPercent);
                publishProgress(downloadPercent);
                if (downloadPercent >= 100){
                    break;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressDialog.setMessage("Downloaded" + values[0] + "%"); //下载进度
    }

    @Override
    protected void onPostExecute(Boolean result) {
        progressDialog.dismiss();
        if (result){ // 下载结果
            Toast.makeText(context, "下载成功！",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "下载失败!",Toast.LENGTH_SHORT).show();
        }
    }

    public int doDownload(int downloadPercent){ //模拟下载
        for (int i=0;i<1000;i++);
        return downloadPercent+1;
    }
}
