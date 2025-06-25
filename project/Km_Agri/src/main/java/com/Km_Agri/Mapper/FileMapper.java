package com.Km_Agri.Mapper;

import com.Km_Agri.Entities.FileEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("insert into files values(#{messageId}, #{fileUrl})")
    void insertFile(FileEntity file);

    @Select({
            "<script>",
            "select * from files",
            "<where>",
            "<if test='message_id!=null'>message_id=#{messageId}</if>",
            "<if test='fileUrl!=null'>and file_url=#{fileUrl}</if>",
            "</where>",
            "</script>"
    })
    List<FileEntity> getFilesByFileEntity(FileEntity file);

    @Select("select * from files")
    List<FileEntity> getAllFiles();



    @Update("update files set fileUrl=#{fileUrl}")
    int updateFiles(String fileUrl);


    @Delete("delete from files where message_id=#{messageId}")
    int deletFileByMesageId(int messageId);

    @Delete("delete from files where message_id=#{fileUrl}")
    int deletFileByUrl(String fileUrl);


}
