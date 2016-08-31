package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    class MyDomParser extends AsyncTask<String, Void, Document>{

        private String getElementText(Element dataElement, String tag){
            NodeList hourNodeList = dataElement.getElementsByTagName(tag);
            Element hourElement = (Element)hourNodeList.item(0);

            NodeList textNodeList = hourElement.getChildNodes();
            return textNodeList.item(0).getNodeValue();
        }
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String strRes = "";
            NodeList nodeList = document.getElementsByTagName("data");
            for(int i=0; i<nodeList.getLength(); i++){
                Element element = (Element)nodeList.item(i);

                strRes += "hour : "+getElementText(element, "hour");
                strRes += "day : "+getElementText(element, "day");
                strRes += "temp : "+getElementText(element, "temp");
                strRes += "wfKor : "+getElementText(element, "wfKor");

            }
        }

        @Override
        protected Document doInBackground(String... params) {
            String strUrl = params[0];
            URL url = null;
            Document doc = null;

            try {
                url = new URL(strUrl);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(url.openStream());

            } catch (Exception e) {
                e.printStackTrace();
            }

            return doc;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDomParser parser = new MyDomParser();
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000");
    }
}
