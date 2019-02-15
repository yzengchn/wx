package com.yzeng.utils.comm;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.yzeng.constans.SysConstans;

/**
 * 读取属性文件
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月16日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class PropertiesLoader {
	
private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
    
    public static String read(String fileName, String key)
    {
        
        if (!propertiesMap.containsKey(fileName) || propertiesMap.get(fileName) == null)
        {
            loadProperty(fileName);
        }
        
        Properties properties = propertiesMap.get(fileName);
        
        return properties.getProperty(key);
    }
    
    public static String getKey(String fileName,String key)
    {
    	//return read(fileName, key);
    	
    	String ciphertext = read(fileName, key);
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(SysConstans.CONFIG_FILE_CIPHER);
        return encryptor.decrypt(ciphertext);

    }
    
    
    public static void main(String[] args) {
    	/*//解密jdbc:mysql://139.199.86.201/charself?characterEncoding=utf-8&useSSL=false
    	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(SysConstans.CONFIG_FILE_CIPHER);
        //String decrypt = encryptor.decrypt("xFYrS41Z+hZQUu5Ar4NLMs5FgIFehTtXzlh1zkLsgXK2QchvGpdUIbSYUUwJf1gmZ/gWTJRfepAIraNOqyaV3Z09gHwI/9bv1ZtSvQnqZw0g2kIpibaEiQ==");
        String decrypt = encryptor.decrypt("vj6RHAkuT7UvXf5GiKKVdA==");
        System.out.println(decrypt);*/
        
        // 默认加密/解密算法是 PBEWithMD5AndDES
        StandardPBEStringEncryptor encryptor1 = new StandardPBEStringEncryptor();
        encryptor1.setPassword(SysConstans.CONFIG_FILE_CIPHER);
        //String encry = encryptor1.encrypt("jdbc:mysql://123.207.236.49/blog?characterEncoding=utf-8&useSSL=false");
        //String encry = encryptor1.encrypt("jdbc:mysql://123.207.236.49/yzblog_user?characterEncoding=utf-8&useSSL=false");
        String encry = encryptor1.encrypt("https://git.dev.tencent.com/yzcod/yzblog-config.git");
        System.out.println(encry);


	}
    /**
     * 描述：加载属性文件
     * @param fileName
     */
    private static void loadProperty(String fileName)
    {
        Properties properties = new Properties();
        
        try
        {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(fileName);
            InputStream in = new BufferedInputStream(resource.getInputStream());
            properties.load(in);
            propertiesMap.put(fileName, properties);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 读取.properties文件对应的标签值
     * 
     * @param path
     * @param propertieName
     * @return
     * @throws Exception 
     */
    public static String getPropertieValue(String path, String propertieName)
    {
        Properties props = new Properties();
//        InputStream in = PropertyLoaderSupport.class.getResourceAsStream(path);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource(path);
        InputStream in =null;
        
        try
        {
            in = new BufferedInputStream(resource.getInputStream());
            props.load(in);
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        finally {
            if(in!=null){
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        return props.getProperty(propertieName);
    }
}
