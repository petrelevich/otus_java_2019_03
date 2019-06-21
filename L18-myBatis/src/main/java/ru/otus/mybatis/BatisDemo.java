package ru.otus.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.otus.mybatis.lesson.Address;
import ru.otus.mybatis.lesson.AddressDao;
import ru.otus.mybatis.lesson.Person;
import ru.otus.mybatis.lesson.PersonDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/*
*
* 0) Не забываем добавлять интерфейсы в mybatis-config.xml и подключать логирование в ehcache.xml
* 1) Реализовать интерфейс PersonDao. Должны поддерживаться методы ''int insert(Person person)'', ''Person selectOne(int id)''
* 2) Реализовать интерфейс AddressDao. Должны поддерживаться методы ''int insert(Address address)'', ''Address selectOne(int id)''
* 3) Реализовать в интерфейсе PersonDao метод ''List<Person> selectByCity(String city)'' (нужен join с таблицей address)
* 4)*Повторить предыдущие задания в xml
*
* */


class BatisDemo {
    private final SqlSessionFactory sqlSessionFactory;

    BatisDemo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
    }

    void start() {
//        selectOne();
//        selectAll();
//        selectLike();
//        selectForEach();
//        insert();
//        selectOneInterface();
//        selectCached();
        selectPersonByCity();
    }

    private void selectPersonByCity() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonDao personDao = session.getMapper(PersonDao.class);
            AddressDao addressDao = session.getMapper(AddressDao.class);

            Person person = new Person();
            person.setId(1);
            person.setFirstName("John");
            person.setLastName("Black");

            Person person2 = new Person();
            person2.setId(2);
            person2.setFirstName("Vadim");
            person2.setLastName("Tisov");

            Address address = new Address();
            address.setId(1);
            address.setPersonId(2);
            address.setCity("Moscow");

            personDao.insert(person);
            personDao.insert(person2);
            addressDao.insert(address);

            System.out.println(personDao.selectByCity("Moscow"));

        }
    }

    private void selectOne() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Test test = session.selectOne("testMapper.selectTestOne", 1);
            System.out.println("selected: " + test);
        }
    }

    private void selectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Map<String, Integer> params = new HashMap<>();
            params.put("minId", 50);
            params.put("maxId", 55);
            List<Test> testList = session.selectList("testMapper.selectTestAll", params);
            System.out.println("selected: " + testList);
        }
    }

    private void selectLike() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Map<String, String> params = new HashMap<>();
            params.put("nameParam", "%2%");
            List<Test> testList = session.selectList("testMapper.selectTestLike", params);
            System.out.println("selected like with nameParam: " + testList);

            testList = session.selectList("testMapper.selectTestLike");
            System.out.println("selected like without nameParam: " + testList);
        }
    }

    private void selectForEach() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Integer> params = Arrays.asList(1,2,3,4,5);
            List<Test> testList = session.selectList("testMapper.selectTestForEach", params);
            System.out.println("selectedForEach: " + testList);
        }
    }

    private void insert() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Map<String, String> params = new HashMap<>();
            params.put("id", "500");
            params.put("name", "TestInsertovich");
            int rowCount = session.insert("testMapper.insert", params);
            System.out.println("inserted: " + rowCount);

            Test test = session.selectOne("testMapper.selectTestOne", 500);
            System.out.println("selected: " + test);
        }
    }

    //Optional добавили в 3.5.0 (только для "интерфейсов")
    private void selectOneInterface() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TestMapperInterface mapper = session.getMapper(TestMapperInterface.class);
            Optional<Test> test = mapper.findOne(1);
            System.out.println("selected: " + test);

            Optional<Test> testNotExists = mapper.findOne(-1);
            System.out.println("selected: " + testNotExists);

        }
    }

    private void selectCached() {
        try (SqlSession session = sqlSessionFactory.openSession()) {

            Test test = session.selectOne("testMapper.selectTestOne", 1);
            System.out.println("1 selected: " + test);

            session.selectOne("testMapper.selectTestOne", 1);
            System.out.println("2 selected: " + test);

            session.selectOne("testMapper.selectTestOne", 1);
            System.out.println("3 selected: " + test);

            session.selectOne("testMapper.selectTestOne", 4);
            System.out.println("4 selected: " + test);

        }
    }


}
