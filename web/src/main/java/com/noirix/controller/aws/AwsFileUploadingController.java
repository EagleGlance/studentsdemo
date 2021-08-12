package com.noirix.controller.aws;

import com.noirix.domain.hibernate.HibernateUser;
import com.noirix.domain.hibernate.UserPhoto;
import com.noirix.repository.springdata.UserDataRepository;
import com.noirix.service.AmazonUploadingFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/aws/upload")
@RequiredArgsConstructor
public class AwsFileUploadingController {

    private final AmazonUploadingFileService service;
    private final UserDataRepository userRepository;

    @PostMapping("/user/{userId}")
    public HibernateUser uploadPhoto(@PathVariable Long userId,
                                     MultipartFile photo) throws Exception {

        Optional<HibernateUser> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            String userPhotoLink = service.uploadFile(photo.getBytes(), userId);

            HibernateUser hibernateUser = userOptional.get();
            Set<UserPhoto> photos = hibernateUser.getPhotos();
            photos.add(new UserPhoto(userPhotoLink));

            hibernateUser.setPhotos(photos);

            return userRepository.save(hibernateUser);
        } else {
            throw new RuntimeException("User not found!");
        }
    }
}
