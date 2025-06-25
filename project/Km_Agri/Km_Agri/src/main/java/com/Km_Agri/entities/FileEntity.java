package com.Km_Agri.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meassage_id")
    private Message message;

    @Column(name = "file_url")
    private String fileUrl;
}
