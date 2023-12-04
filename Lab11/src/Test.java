public class Test {
	public static void main(String[] args) {
		BST<Integer> b1 = new BST<Integer>();
		b1.add(5);
		b1.add(7);
		b1.add(2);
		b1.add(4);
		b1.add(10);
		b1.add(1);
		b1.add(6);
		b1.add(12);
		b1.add(9);
		b1.add(20);
		System.out.println("Depth : " + b1.depth(20));
		System.out.println("----------------------------");
		System.out.println("Height: " + b1.height());
		System.out.println("----------------------------");
		System.out.println("Size: " + b1.size());
		System.out.println("----------------------------");
		System.out.println("Contains : " + b1.contains(50));
		System.out.println(b1.contains(10));
		System.out.println("----------------------------");
		System.out.println("findMin: " + b1.findMin());
		System.out.println("----------------------------");
		System.out.println("findMax: " + b1.findMax());
		System.out.println("----------------------------");
		System.out.println("remove: " + b1.remove(12));
		System.out.println("----------------------------");
		System.out.println("Ancestors : " + b1.ancestors(10));
		System.out.println("----------------------------");
		System.out.println("InOrder: ");
		b1.inorder();
		System.out.println("----------------------------");
		System.out.println("Pre-order: ");
		b1.preorder();
		System.out.println("----------------------------");
		System.out.println("Post-order: ");
		b1.postorder();
	}
}
