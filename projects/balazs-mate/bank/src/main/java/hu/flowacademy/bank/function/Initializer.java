package hu.flowacademy.bank.function;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.flowacademy.bank.model.BankUser;
import hu.flowacademy.bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Initializer {

    @Autowired
    BankUserService bankUserService;

    public static List<BankUser> importBankUsers() {

        List<BankUser> list = new ArrayList<>();

        String importPath = "/home/balmate/FlowAcademy_local_projects/p3_bank/flow_work_earth_spring/projects/balazs-mate/bank/src/main/resources/static/json/user03.json";
        Path path = Paths.get(importPath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            List<BankUser> importedBankUserList = mapper.readValue(new File(importPath), new TypeReference<List<BankUser>>() {
            });

            importedBankUserList.stream().forEach(System.out::println);
            list.addAll(importedBankUserList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Json based date: imported");
        return list;

    }
}
