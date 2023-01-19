package com.air.demo.common.Config;
import com.air.demo.masterData.Repository.MasterLanguageRepository;
import com.air.demo.masterData.entity.MasterLanguage;
import com.air.demo.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.air.demo.user.Entity.user.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
public class InsertTableBean {


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    Environment environment;

    @Autowired
    MasterLanguageRepository masterLanguageRepository;





    @Bean
    public void saveRole() {
        if (roleRepository.findAll().isEmpty()) {
            List<Role> roleList = new ArrayList<>();
            roleList.add(new Role(1L, "ROLE_SUPER_ADMIN", Integer.parseInt(Objects.requireNonNull(environment.getProperty("active")))));
            roleList.add(new Role(2L, "ROLE_OPS_TEAM", Integer.parseInt(Objects.requireNonNull(environment.getProperty("active")))));
            roleList.add(new Role(3L, "ROLE_ADVISOR", Integer.parseInt(Objects.requireNonNull(environment.getProperty("active")))));
            roleList.add(new Role(4L, "ROLE_CUSTOMER", Integer.parseInt(Objects.requireNonNull(environment.getProperty("active")))));

            roleRepository.saveAll(roleList);
        }
    }

    @Bean
    public void saveMasterLanguage() {
        if (masterLanguageRepository.findAll().isEmpty()) {
            masterLanguageRepository.deleteAll();
            masterLanguageRepository.save(new MasterLanguage(1L, "Afrikaans", 1));
            masterLanguageRepository.save(new MasterLanguage(2L, "Albanian", 1));
            masterLanguageRepository.save(new MasterLanguage(3L, "Arabic", 1));
            masterLanguageRepository.save(new MasterLanguage(4L, "Basque", 1));
            masterLanguageRepository.save(new MasterLanguage(5L, "Belarusian", 1));
            masterLanguageRepository.save(new MasterLanguage(6L, "Bulgarian", 1));
            masterLanguageRepository.save(new MasterLanguage(7L, "Catalan", 1));
            masterLanguageRepository.save(new MasterLanguage(8L, "Chinese", 1));
            masterLanguageRepository.save(new MasterLanguage(9L, "Croatian", 1));
            masterLanguageRepository.save(new MasterLanguage(10L, "Czech", 1));
            masterLanguageRepository.save(new MasterLanguage(11L, "Danish", 1));
            masterLanguageRepository.save(new MasterLanguage(12L, "Dutch", 1));
            masterLanguageRepository.save(new MasterLanguage(13L, "English", 1));
            masterLanguageRepository.save(new MasterLanguage(14L, "Estonian", 1));
            masterLanguageRepository.save(new MasterLanguage(15L, "Faeroese", 1));
            masterLanguageRepository.save(new MasterLanguage(16L, "Farsi", 1));
            masterLanguageRepository.save(new MasterLanguage(17L, "Finnish", 1));
            masterLanguageRepository.save(new MasterLanguage(18L, "French", 1));
            masterLanguageRepository.save(new MasterLanguage(19L, "Gaelic", 1));
            masterLanguageRepository.save(new MasterLanguage(20L, "German", 1));
            masterLanguageRepository.save(new MasterLanguage(21L, "Greek", 1));
            masterLanguageRepository.save(new MasterLanguage(22L, "Hebrew", 1));
            masterLanguageRepository.save(new MasterLanguage(23L, "Hindi", 1));
            masterLanguageRepository.save(new MasterLanguage(24L, "Hungarian", 1));
            masterLanguageRepository.save(new MasterLanguage(25L, "Icelandic", 1));
            masterLanguageRepository.save(new MasterLanguage(26L, "Indonesian", 1));
            masterLanguageRepository.save(new MasterLanguage(27L, "Irish", 1));
            masterLanguageRepository.save(new MasterLanguage(28L, "Italian", 1));
            masterLanguageRepository.save(new MasterLanguage(29L, "Japanese", 1));
            masterLanguageRepository.save(new MasterLanguage(30L, "Korean", 1));
            masterLanguageRepository.save(new MasterLanguage(31L, "Kurdish", 1));
            masterLanguageRepository.save(new MasterLanguage(32L, "Latvian", 1));
            masterLanguageRepository.save(new MasterLanguage(33L, "Lithuanian", 1));
            masterLanguageRepository.save(new MasterLanguage(34L, "Macedonian", 1));
            masterLanguageRepository.save(new MasterLanguage(35L, "Malayalam", 1));
            masterLanguageRepository.save(new MasterLanguage(36L, "Malaysian", 1));
            masterLanguageRepository.save(new MasterLanguage(37L, "Maltese", 1));
            masterLanguageRepository.save(new MasterLanguage(38L, "Norwegian", 1));
            masterLanguageRepository.save(new MasterLanguage(39L, "Polish", 1));
            masterLanguageRepository.save(new MasterLanguage(41L, "Portuguese", 1));
            masterLanguageRepository.save(new MasterLanguage(42L, "Punjabi", 1));
            masterLanguageRepository.save(new MasterLanguage(43L, "Romanian", 1));
            masterLanguageRepository.save(new MasterLanguage(44L, "Russian", 1));
            masterLanguageRepository.save(new MasterLanguage(45L, "Serbian", 1));
            masterLanguageRepository.save(new MasterLanguage(46L, "Slovak", 1));
            masterLanguageRepository.save(new MasterLanguage(47L, "Slovenian", 1));
            masterLanguageRepository.save(new MasterLanguage(48L, "Sorbian", 1));
            masterLanguageRepository.save(new MasterLanguage(49L, "Spanish", 1));
            masterLanguageRepository.save(new MasterLanguage(50L, "Swedish", 1));
            masterLanguageRepository.save(new MasterLanguage(51L, "Thai", 1));
            masterLanguageRepository.save(new MasterLanguage(52L, "Tsonga", 1));
            masterLanguageRepository.save(new MasterLanguage(53L, "Tswana", 1));
            masterLanguageRepository.save(new MasterLanguage(54L, "Turkish", 1));
            masterLanguageRepository.save(new MasterLanguage(55L, "Ukrainian", 1));
            masterLanguageRepository.save(new MasterLanguage(56L, "Urdu", 1));
            masterLanguageRepository.save(new MasterLanguage(57L, "Venda", 1));
            masterLanguageRepository.save(new MasterLanguage(58L, "Vietnamese", 1));
            masterLanguageRepository.save(new MasterLanguage(59L, "Welsh", 1));
            masterLanguageRepository.save(new MasterLanguage(60L, "Xhosa", 1));
            masterLanguageRepository.save(new MasterLanguage(61L, "Yiddish", 1));
            masterLanguageRepository.save(new MasterLanguage(62L, "Zulu", 1));
        }
    }



}
