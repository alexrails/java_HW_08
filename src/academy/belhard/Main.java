package academy.belhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	Address address1 = new Address("Minsk", "Lenina", 1);
	Address address2 = new Address("Minsk", "Kirova", 78);
	Address address3 = new Address("Brest", "Lenina", 4);
	Address address4 = new Address("Moscow", "Tverskaya", 111);
	Address address5 = new Address("NewYork", "78", 3);

	Person p1 = new Person("John", "Doe", address3);
	Person p2 = new Person("Elizabet", "Kudrow", address1);
	Person p3 = new Person("Jimm", "Carry", address2);
	Person p4 = new Person(null, "Lenin", address5);
	Person p5 = new Person("Alex", null, address4);
	Person p6 = new Person("Maks", "Barell", null);

	List<Person> persons = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

	List<String> list = persons
						.stream()
						.filter(item -> item.getFirstname() != null &&
										item.getLastname() != null &&
										item.getAddress() != null)
						.sorted((item1, item2) -> item1.getAddress().getHomeNumber() -
										          item2.getAddress().getHomeNumber())
						.map(item -> item.toString())
						.collect(Collectors.toList());

	for(String item : list) {
		System.out.println(item);
	}
    }
}
