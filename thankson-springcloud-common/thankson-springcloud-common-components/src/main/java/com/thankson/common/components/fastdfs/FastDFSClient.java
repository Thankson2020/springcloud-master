package com.thankson.common.components.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ServerInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FastDFS文件上传
 *
 * @author Thankson
 * @date 2020年3月1日
 */
public class FastDFSClient {

    static {
        //获取FastDFS的配置文件路径
        String path = new ClassPathResource("fdfs_client.conf").getPath();
        try {
            //加载tracker配置信息
            ClientGlobal.init(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取StorageClient对象
     *
     * @return
     * @throws IOException
     * @author Thankson
     * @date 2020年3月1日
     */
    private static StorageClient getStorageClient() throws IOException {
        //创建TrackerClient客户端对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient对象获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取StorageClient对象
        return new StorageClient(trackerServer, null);
    }

    /**
     * 图片上传
     *
     * @param file 图片信息
     * @return String
     * @author Thankson
     * @date 2020年3月1日
     */
    public static String upload(FastDFSFile file) {
        //文件信息
        NameValuePair[] meta_list = new NameValuePair[]{
                new NameValuePair(file.getAuthor()),
                new NameValuePair(file.getName()),
        };
        try {
            /*
             * 文件上传后的返回值
             * uploadResults[0]:文件上传所存储的组名，例如:group1
             * uploadResults[1]:文件存储路径,例如：M00/00/00/wKjThF0DBzaAP23MAAXz2mMp9oM26.jpeg
             */

            String[] uploadResults = getStorageClient().upload_file(file.getContent(), file.getExt(), meta_list);
            if(uploadResults.length==0){
                return null;
            }
            return getTrackerUrl()+"/"+uploadResults[0]+"/"+uploadResults[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 文件下载
     *
     * @param groupName      Storage组
     * @param remoteFileName 文件存储完整名
     * @return InputStream
     * @author Thankson
     * @date 2020年3月1日
     */
    public static InputStream downFile(String groupName, String remoteFileName) {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            //通过StorageClient下载文件
            byte[] bytes = getStorageClient().download_file(groupName, remoteFileName);
            //将字节数组转换成字节输入流
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            return byteArrayInputStream;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 删除图片
     *
     * @param groupName      Storage组
     * @param remoteFileName 文件存储完整名
     * @return boolean
     * @author Thankson
     * @date 2020年3月1日
     */
    public static boolean deleteFile(String groupName, String remoteFileName) {
        try {
            int result = getStorageClient().delete_file(groupName, remoteFileName);
            if (result == 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取组信息
     *
     * @param groupName 组名
     * @return StorageServer
     * @author Thankson
     * @date 2020年3月1日
     */
    public static StorageServer getStorage(String groupName) {
        try {
            //创建TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();
            //通过TrackerClient获取TrackerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();
            //通过trackerClient获取Storage组信息
            return trackerClient.getStoreStorage(trackerServer, groupName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据文件名和组名获取文件的信息
     *
     * @param groupName      组名
     * @param remoteFileName 文件存储完整名
     * @return FileInfo
     * @author Thankson
     * @date 2020年3月1日
     */
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            //获取服务信息
            return getStorageClient().get_file_info(groupName, remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据文件组名和文件存储路径获取Storage服务的IP、端口信息
     *
     * @param groupName      :组名
     * @param remoteFileName ：文件存储完整名
     * @return ServerInfo[]
     * @author Thankson
     * @date 2020年3月1日
     */
    public static ServerInfo[] getServerInfo(String groupName, String remoteFileName) {
        try {
            //创建TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();
            //通过TrackerClient获取TrackerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取服务信息
            return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 获取Tracker服务地址
     *
     * @return String
     * @author Thankson
     * @date 2020年3月1日
     */
    public static String getTrackerUrl() {
        try {
            //创建TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();
            //通过TrackerClient获取TrackerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Tracker地址
            String hostString = trackerServer.getInetSocketAddress().getHostString();
            int g_tracker_http_port = ClientGlobal.getG_tracker_http_port();
            return "http://" + hostString + ":" + g_tracker_http_port;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

