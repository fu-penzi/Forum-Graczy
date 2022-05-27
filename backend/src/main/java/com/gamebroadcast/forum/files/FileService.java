package com.gamebroadcast.forum.files;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import javax.sound.midi.Soundbank;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class FileService {
    //@Value("${fileservice.path}")
    private final String PATH = "src\\main\\resources\\content";

    public String getUniqueName(String username) {
        String phrase = username + System.currentTimeMillis();
        String name = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(phrase.getBytes());
            byte[] digest = md.digest();
            name = Base64Utils.encodeToString(digest).substring(0,8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return name;
    }

    private boolean isPathExists(String path) {
        File dir = new File(path);
        return dir.exists();
    }

    private void createFolder(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println(path);
        }

    }
    public void writeHtmlContent(String hash, String htmlContent) {
        createFolder(PATH + "\\" + hash);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(PATH + "\\" + hash + "\\" + "content.html"))) {
            buffer.write(htmlContent);
        } catch (IOException e) {
            // TODO add custom exception
            throw new NullPointerException(e.getMessage());
        }
    }

    public String parseJson(String editorData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(editorData);
        String pictureUrl = root.get("entityMap").get("0").get("data").get("src").textValue();
        return pictureUrl;
    }

    public BufferedImage downloadImageFromUrl(String urlString) {
        try {
            System.out.println(urlString);
            URL url = new URL(urlString);
            System.out.println("Nie zrobiłem URLa");
            BufferedImage image = ImageIO.read(url);
            return image;
        } catch (IOException e) {
            // TODO add custom exception
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void saveImage(String path, BufferedImage image) {
        try {
            File out = new File(path);
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            // TODO add custom exception
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String saveNewContent(String content, String username) {
        String hash = getUniqueName(username);
        writeHtmlContent(hash, content);
        return hash;
    }
}