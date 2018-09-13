package fileIO;

import java.io.*;

/**
 * Created by cdyujing7 on 2017/12/6.
 */
public class FileRelated {
    public static void main(String[] args) {
        appendFileByFileWriter("D:/mySourceCode/test.txt", "中文");
        appendFileByBufferedWriter("D:/mySourceCode/test.txt", "是是", "utf-8");
    }

    /**
     * 以字节为单位读取文件，常用于读取二进制文件，如图片、声音等
     * @param fileName
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int tmpByte;
            while ((tmpByte = inputStream.read()) != -1) {
                System.out.print(tmpByte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 以字符为单位读取文件
     * @param fileName
     * @param code 编码方式
     */
    public static void readFileByChars(String fileName, String code) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file), code);
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 以行为单位读入字符
     * @param fileName
     * @param code 编码方式
     */
    public static void readFileByLines(String fileName, String code) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), code));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 将字符添加到文件中 支持编码
     * @param fileName
     * @param content
     */
    public static void appendFileByBufferedWriter(String fileName, String content, String code) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), code));
            writer.append(content);
            writer.newLine();
            writer.append(content);
        } catch (Exception e) {

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {

            }
        }
    }

    /**
     * 将字符加到文件中 不支持编码
     * @param fileName
     * @param content
     */
    public static void appendFileByFileWriter(String fileName, String content) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            for (int i = 1; i < 3; i++) {
                writer.append(content + i + "\n");
                writer.flush();
            }
        } catch (Exception e) {

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
