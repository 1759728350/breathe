import java.io.*;

public class Format {
    public static void main(String[] args) throws Exception {
        if (args[0] == null || args[1] == null || args[0] == " " || args[1] == " "){
            return;
        }
        // 创建流对象
        //"E:\\Git\\my_all_repositories\\regression\\软件测试\\第一章.md"
        BufferedReader br = new BufferedReader(
                new FileReader(args[0]));
        //"E:\\Git\\my_all_repositories\\regression\\软件测试\\第二章.md"
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(args[1]));
        // 定义字符串,保存读取的一行文字
        String line  = null;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine())!=null) {
            System.out.print(line+"  ");
            System.out.println();
            bw.write(line+"  ");
            bw.newLine();
        }

        // 释放资源
        br.close();
        bw.close();
    }
}
