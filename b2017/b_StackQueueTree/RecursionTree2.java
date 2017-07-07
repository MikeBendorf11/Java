package b_StackQueueTree;

import java.util.ArrayList;
import java.util.List;

public class RecursionTree2 extends RecursionTree1 {
	int dpT, dpM, leafs;
	
	void depth(){
		dpT = dpM = leafs = 0;
		dptotal(root, 0);		
	}
	
	int dpmax(int depth){
		return (depth>dpM) ? depth:dpM;
	}
	
	void dptotal(TreeNode root, int i) {
		if (root != null) {
			i++;
			dptotal(root.left, i);
			dptotal(root.right, i);
			
			if (root.left == null && root.right == null) {
				i--;
				leafs++;
				dpT = dpT + i;
				dpM = dpmax(i);
				System.out.print("Leaf: " + root.item);
				System.out.print(", Leafs Count: " + leafs);
				System.out.print(", Depth Sum: " + dpT);
				System.out.print(", Average Depth: " 
									+ (double)dpT/leafs);
				System.out.println();
			}	
		} 
	}
//" dpT/lfc2: " + dpT/lfc2 + 
	
	 void print2(TreeNode root) {
		List<List<String>> lines = new ArrayList<List<String>>();

		List<TreeNode> level = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();

		level.add(root);
		int nn = 1;

		int widest = 0;

		while (nn != 0) {
			List<String> line = new ArrayList<String>();

			nn = 0;

			for (TreeNode n : level) {
				if (n == null) {
					line.add(null);

					next.add(null);
					next.add(null);
				} else {
					String aa = n.getText();
					line.add(aa);
					if (aa.length() > widest)
						widest = aa.length();

					next.add(n.getLeft());
					next.add(n.getRight());

					if (n.getLeft() != null)
						nn++;
					if (n.getRight() != null)
						nn++;
				}
			}

			if (widest % 2 == 1)
				widest++;

			lines.add(line);

			List<TreeNode> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}

		int perpiece = lines.get(lines.size() - 1).size() * (widest + 2);
		for (int i = 0; i < lines.size(); i++) {
			List<String> line = lines.get(i);
			int hpw = (int) Math.floor(perpiece / 2f) - 1;

			if (i > 0) {
				for (int j = 0; j < line.size(); j++) {

					// split node
					char c = ' ';
					if (j % 2 == 1) {
						if (line.get(j - 1) != null) {
							c = (line.get(j) != null) ? '┴' : '┘';
						} else {
							if (j < line.size() && line.get(j) != null)
								c = '└';
						}
					}
					System.out.print(c);

					// lines and spaces
					if (line.get(j) == null) {
						for (int k = 0; k < perpiece - 1; k++) {
							System.out.print(" ");
						}
					} else {

						for (int k = 0; k < hpw; k++) {
							System.out.print(j % 2 == 0 ? " " : "─");
						}
						System.out.print(j % 2 == 0 ? "┌" : "┐");
						for (int k = 0; k < hpw; k++) {
							System.out.print(j % 2 == 0 ? "─" : " ");
						}
					}
				}
				System.out.println();
			}

			// print line of numbers
			for (int j = 0; j < line.size(); j++) {

				String f = line.get(j);
				if (f == null)
					f = "";
				int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
				int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

				// a number
				for (int k = 0; k < gap1; k++) {
					System.out.print(" ");
				}
				System.out.print(f);
				for (int k = 0; k < gap2; k++) {
					System.out.print(" ");
				}
			}
			System.out.println();

			perpiece /= 2;
		}
	}
}