package chapter15;

import java.util.*;

public class question1526 {

	public static void main(String[] args) {
		final HashMap<Character, Double> frequencies = new HashMap<Character, Double>();
		ArrayList<Character> chars = new ArrayList<Character>();
		Random r = new Random();
		for (int i = (int) 'A'; i <= (int) 'z'; i++) {
			frequencies.put((char) i, (double) r.nextInt(100) / 100);
			chars.add((char) i);
		}
		HashMap<Character, String> code = huffmanCode(frequencies);
		Collections.sort(chars, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return (int) Math.signum(frequencies.get(o1)
						- frequencies.get(o2));
			}
		});
		for (Character c : chars) {
			System.out.println(c + " : " + frequencies.get(c) + " "
					+ code.get(c));
		}
	}

	public static class HuffmanNode implements Comparable<HuffmanNode> {
		double frequency;
		char c;

		public HuffmanNode leftNode;
		public HuffmanNode rightNode;

		public HuffmanNode(double frequency, char c) {
			this.frequency = frequency;
			this.c = c;
			this.leftNode = null;
			this.rightNode = null;
		}

		public static HuffmanNode merge(HuffmanNode n1, HuffmanNode n2) {
			HuffmanNode newOne = new HuffmanNode(n1.frequency + n2.frequency,
					' ');
			newOne.leftNode = n1;
			newOne.rightNode = n2;
			return newOne;
		}

		public int compareTo(HuffmanNode n) {
			double diff = frequency - n.frequency;
			if (diff != 0) {
				return (int) Math.signum(diff);
			}
			// Just so that nodes with the same frequencies will not be thought
			// to be the same
			return hashCode() - n.hashCode();
		}
	}

	public static HashMap<Character, String> huffmanCode(
			HashMap<Character, Double> frequencies) {
		TreeSet<HuffmanNode> nodes = new TreeSet<HuffmanNode>();
		for (Map.Entry<Character, Double> pair : frequencies.entrySet()) {
			nodes.add(new HuffmanNode(pair.getValue(), pair.getKey()));
		}

		while (nodes.size() != 1) {
			HuffmanNode n1 = nodes.pollFirst();
			HuffmanNode n2 = nodes.pollFirst();
			nodes.add(HuffmanNode.merge(n1, n2));
		}

		HashMap<Character, String> code = new HashMap<Character, String>();
		LinkedList<String> sequence = new LinkedList<String>();
		GenerateHuffmanCode(nodes.first(), sequence, true, code);
		return code;
	}

	public static void GenerateHuffmanCode(HuffmanNode root,
			LinkedList<String> sequence, boolean isLeft,
			HashMap<Character, String> result) {
		if (isLeft) {
			sequence.addLast("1");
		} else {
			sequence.addLast("0");
		}

		if (root.leftNode == null && root.rightNode == null) {
			result.put(root.c, linkedListToString(sequence));
		} else {
			GenerateHuffmanCode(root.leftNode, sequence, true, result);
			GenerateHuffmanCode(root.rightNode, sequence, false, result);
		}
		sequence.removeLast();
		return;
	}

	public static String linkedListToString(LinkedList<String> l) {
		StringBuilder sb = new StringBuilder();
		for (String s : l) {
			sb.append(s);
		}
		return sb.toString();
	}
}
