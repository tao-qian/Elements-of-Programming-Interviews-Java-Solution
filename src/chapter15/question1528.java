package chapter15;

import java.util.*;

public class question1528 {

	public static void main(String[] args) {

	}

	public static class Person {
		HashSet<Person> connecting;
		HashSet<Person> connected;
		String name;

		public Person(String name) {
			this.name = name;
			connecting = new HashSet<Person>();
			connected = new HashSet<Person>();
		}

		public int hashCode() {
			return name.hashCode();
		}

		public boolean equal(Object o) {
			if (o == null) {
				return false;
			}
			if (this == o) {
				return true;
			}
			if (!(o instanceof Person)) {
				return false;
			}
			return o.hashCode() == hashCode();
		}
	}

	public HashMap<String, Person> planParty(HashMap<String, String> connections) {
		HashMap<String, Person> people = new HashMap<String, Person>();
		// Build the graph
		for (Map.Entry<String, String> connection : connections.entrySet()) {
			Person connecting = people.get(connection.getKey());
			if (connecting == null) {
				connecting = new Person(connection.getKey());
				people.put(connection.getKey(), connecting);
			}
			Person connected = people.get(connection.getValue());
			if (connected == null) {
				connected = new Person(connection.getValue());
				people.put(connection.getValue(), connecting);
			}
			connecting.connecting.add(connected);
			connected.connected.add(connected);
		}

		while (true) {
			Person toBeRemoved = null;
			for (Map.Entry<String, Person> person : people.entrySet()) {
				if (person.getValue().connecting.size() < 3
						|| people.size() - person.getValue().connecting.size() < 3) {
					toBeRemoved = person.getValue();
					break;
				}
			}

			if (toBeRemoved == null) {
				return people;
			}
			for (Person p : toBeRemoved.connected) {
				p.connecting.remove(toBeRemoved);
			}
			people.remove(toBeRemoved.name);
		}
	}
}
