package com.yzeng.utils.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 发送HTTP请求的工具类
 * <一句话功能简述>
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class HttpConnect {
    private static HttpConnect httpConnect = new HttpConnect();

    private static final String CONTENT_CHARSET = "UTF-8";
    
    private static MultiThreadedHttpConnectionManager connectionManager;
    
    private static HttpClient client;
    
    private HttpConnect() {
        connectionManager=new MultiThreadedHttpConnectionManager();
        client = new HttpClient(connectionManager);
        client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
        client.getHttpConnectionManager().getParams().setSoTimeout(55000);
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, CONTENT_CHARSET);
    }
    
    /**
     * 工厂方法
     * 
     * @return
     */
    public static HttpConnect getInstance() {
        return httpConnect;
    }


    /**
     * 预定接口的返回处理，对特殊字符进行过滤 
     * @author yzblog.xyz
     * @date 2018年11月16日 下午2:44:24
     * @title	doGetStr
     * @param url
     * @return String
     */
    public String doGetStr(String url) {
        HttpMethod method = new GetMethod(url);
        try {
            client.executeMethod(method);
            return method.getResponseBodyAsString();
        } catch (HttpException e) {
            method.releaseConnection();
            return null;
        } catch (IOException e) {
            method.releaseConnection();
            return null;
        } finally {
            method.releaseConnection();
        }
    }

    public String doPostStr(String url, String menuJson) {
        PostMethod method = new PostMethod(url);
        RequestEntity requestEntity;
        try {
            requestEntity = new StringRequestEntity(menuJson, "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            client.executeMethod(method);
            return method.getResponseBodyAsString();
        } catch (HttpException e) {
            method.releaseConnection();
            return null;
        } catch (IOException e) {
            method.releaseConnection();
            return null;
        } finally {
            method.releaseConnection();
        }
    }
    
    /**
     * 预定接口的返回处理，对特殊字符进行过滤 
     * @author yzblog.xyz
     * @date 2018年11月16日 下午2:44:24
     * @title	doPostStr
     * @param url
     * @return String
     */
    public String doPostStr(String url) {
        HttpMethod method = new PostMethod(url);
        try {
            client.executeMethod(method);
            return method.getResponseBodyAsString();
        } catch (HttpException e) {
            method.releaseConnection();
            return null;
        } catch (IOException e) {
            method.releaseConnection();
            return null;
        } finally {
            method.releaseConnection();
        }
    }
    
    public String postFile(String url,File file){
        String result=null;
        PostMethod method = new PostMethod(url);
        try {
            Part[] parts=new Part[]{new FilePart(file.getName(),file)};
            method.setRequestEntity(new MultipartRequestEntity(parts,method.getParams()));
            client.executeMethod(method);
            result=method.getResponseBodyAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return result;
    }
    public void getFile(String url,String path){
        GetMethod method=new GetMethod(url);
        try {
            client.executeMethod(method);
            InputStream in = method.getResponseBodyAsStream();
            FileOutputStream out = new FileOutputStream(new File(path));
            byte[] b = new byte[1024];
            int len = 0;
            while((len=in.read(b))!= -1){
                out.write(b,0,len);
            }   
            in.close();   
            out.close();   
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            method.releaseConnection();
        }
    }
}

