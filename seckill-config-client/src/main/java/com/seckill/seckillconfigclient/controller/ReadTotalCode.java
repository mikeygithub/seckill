package com.seckill.seckillconfigclient.controller;

import java.io.*;
import java.util.regex.Pattern;

/**
 * @ProjectName seckill
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 5/14/20 7:56 AM
 * @Version 1.0
 * @Title: ReadTotalCode
 * @Description:
 **/

public class ReadTotalCode {

    //源代码目录
    public static final String DIR_PATH = "/home/mikey/Downloads/gdm-master";
    //系统分割符
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    //要读取的文件后缀
    public static final String FILE_SUFFIX = ".*.java|.*.jsp|.*.html|.*.properties|.*.xml|.*.sql|.*.js";
    //输出目标文件
    public static final String TARGET_FILE = "/home/mikey/Downloads/total_code.txt";

    public void readFile(String filepath) {

        File file = new File(filepath);

        if (!file.isDirectory() && Pattern.matches(FILE_SUFFIX, file.getName())) {//非文件夹

            writer(file);

        } else if (file.isDirectory()) {

            String[] fileList = file.list();

            for (int i = 0; i < fileList.length; i++) {

                File readfile = new File(filepath + FILE_SEPARATOR + fileList[i]);

                if (!readfile.isDirectory() && Pattern.matches(FILE_SUFFIX, readfile.getName())) {//非文件夹

                    writer(readfile);

                } else if (readfile.isDirectory()) {

                    readFile(filepath + FILE_SEPARATOR + fileList[i]);

                }
            }

        }

    }

    public void writer(File file) {

        System.out.println("读取文件:" + file.getName());

        BufferedReader reader = null;
        FileWriter fileWriter = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            fileWriter = new FileWriter(TARGET_FILE, true);

            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                fileWriter.write(tempString + "\n");
            }
            reader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReadTotalCode readTotalCode = new ReadTotalCode();
        readTotalCode.readFile(DIR_PATH);
    }
}
