package com.example.demo.data_structures.huffmancode;


import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @ClassName: HuffmanCode
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/3 20:59
 * @Version: 1.0
 */
public class HuffmanCode {

    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
//        System.out.println(Integer.toBinaryString(8 | 256));
//        byte[] contentBytes = content.getBytes();
//        Node huffmanTree = createHuffmanTree(getNodes(contentBytes));
//        huffmanTree.preOrder();
//        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
//        System.out.println(huffmanCodes);
//        byte[] zip = zip(contentBytes, huffmanCodes);
//        System.out.println(Arrays.toString(zip));
//        byte[] bytes = huffmanZip(content);
//        System.out.println(Arrays.toString(bytes));
//        byte[] decode = decode(huffmanCodes, bytes);
//        System.out.println(new String(decode));
//        zipFile("F:\\test.bmp","F:\\test.zip");
        unZipFile("F:\\test.zip","F:\\aa.bmp");
    }

    public static void unZipFile(String zipFile,String dstFile) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(zipFile);
            ois = new ObjectInputStream(fis);
            byte[] bytes = (byte[]) ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            byte[] decodeBytes = decode(huffmanCodes, bytes);
            fos = new FileOutputStream(dstFile);
            fos.write(decodeBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                assert fos != null;
                fos.close();
                assert fis != null;
                fis.close();
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void zipFile(String srcFile,String dstPath){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream obs = null;
        try {
            fis = new FileInputStream(srcFile);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] huffmanBytes = huffmanZip(bytes);
            fos = new FileOutputStream(dstPath);
            obs = new ObjectOutputStream(fos);
            obs.writeObject(huffmanBytes);
            obs.writeObject(huffmanCodes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fis != null;
                fis.close();
                assert fos != null;
                fos.close();
                assert obs != null;
                obs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        Map<String,Byte> stringByteMap = new HashMap<>();
        huffmanCodes.forEach((key, val) -> stringByteMap.put(val, key));
        List<Byte> bytes = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte huffmanByte = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag,huffmanByte));
        }
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag){
                String s = stringBuilder.substring(i,i+count);
                b = stringByteMap.get(s);
                if (b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            bytes.add(b);
            i += count;
        }

        byte[] bytes1 = new byte[bytes.size()];
        int index = 0;
        for (Byte aByte : bytes) {
            bytes1[index] = aByte;
            index ++;
        }
        return bytes1;
    }

    private static String byteToBitString(boolean flag,byte b){
        int temp = b;
        if (flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    public static byte[] huffmanZip(String content){
        if (content == null || content == ""){
            return null;
        }
        byte[] contentBytes = content.getBytes();

        return huffmanZip(contentBytes);
    }
    public static byte[] huffmanZip(byte[] contentBytes){
        if (contentBytes == null || contentBytes.length == 0){
            return null;
        }
        //生成huffman树
        Node huffmanTree = createHuffmanTree(getNodes(contentBytes));
        //生成huffman编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
        //得到压缩后的字节数组
        byte[] zip = zip(contentBytes, huffmanCodes);
        return zip;
    }

    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCodes.get(aByte));
        }
//        System.out.println(stringBuilder.toString());
        int len;
        if (stringBuilder.length() / 8 == 0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8 + 1 ;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte;
            if (i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            int b = Integer.parseInt(strByte,2);
            huffmanCodeBytes[index] = (byte)b;
            index++;
        }
        return huffmanCodeBytes;
    }


    private static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        getCodes(root,"",stringBuilder);
        return huffmanCodes;
    }

    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null){
            if (node.data == null){
                getCodes(node.left,"0",stringBuilder1);
                getCodes(node.right,"1",stringBuilder1);
            }else {
                huffmanCodes.put(node.data,stringBuilder1.toString());
            }
        }
    }

    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            //1.排序
            Collections.sort(nodes);
            //2.
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.getWeight()+rightNode.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }

    private static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }
    }
    static class Node implements Comparable<Node>{

        private Byte data;
        private int weight;
        private Node left;
        private Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        //前序遍历
        public void preOrder(){
            System.out.println(this);
            if (this.left != null){
                this.left.preOrder();
            }
            if (this.right != null){
                this.right.preOrder();
            }
        }

        public Byte getData() {
            return data;
        }

        public void setData(Byte data) {
            this.data = data;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
