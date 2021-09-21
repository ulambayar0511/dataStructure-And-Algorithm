// AVL tree

package dataStructures;

public class AVLtree extends BinarySearchTree
{
   // top-level nested class
   static class AVLElement
   {
      // data members
      Object element;        // element in node
      int bf;                // balance factor of node

      // constructors
      AVLElement(int theBalanceFactor, Object theElement)
      {
         bf = theBalanceFactor;
         element = theElement;
      }

      AVLElement(Object theElement)
         {element = theElement;}

      /** @return equivalent string suitable for output */
      public String toString()
         {return element.toString();}
   }

   // ascend is inherited from BinarySearchTree

   /** @return element whose key is theKey
     * @return null if there is no element with key theKey */
   public Object get(Object theKey)
   {
      Object theElement = super.get(theKey);
      if (theElement == null)
         // no matching element
         return null;
      else
         return ((AVLElement) theElement).element;
   }

   /** set balance factors on path from q to r */
   static void fixBF(BinaryTreeNode q, BinaryTreeNode r, Comparable theKey)
   {// Balance factors from q to r were originally 0.
    // They need to be changed to +1 or -1.
    // Use theKey to find path from q to r.
   
      while (q != r)
         if (theKey.compareTo(((Data) q.element).key) < 0)
         {// height of left subtree has increased
            ((AVLElement) ((Data) q.element).element).bf = 1;
            q = q.leftChild;
         }
         else
         {// height of right subtree has increased
            ((AVLElement) ((Data) q.element).element).bf = -1;
            q = q.rightChild;
         }
   }
   
   /** LL rotation around a, pa is parent of a and b is left child of a */
   void llRotate(BinaryTreeNode pa, BinaryTreeNode a, BinaryTreeNode b)
   {
      // restructure subtree at A
      a.leftChild = b.rightChild;
      b.rightChild = a;
      if (pa != null)
         // a is not the root
         if (a == pa.leftChild)
            pa.leftChild = b;
         else
            pa.rightChild = b;
      else
         root = b;
   
      // set balance factors
      ((AVLElement) ((Data) a.element).element).bf = 0;
      ((AVLElement) ((Data) b.element).element).bf = 0;
   }
   
   /** RR rotation around a, pa is parent of a and b is right child of a */
   void rrRotate(BinaryTreeNode pa, BinaryTreeNode a, BinaryTreeNode b)
   {
      // restructure subtree at a
      a.rightChild = b.leftChild;
      b.leftChild = a;
      if (pa != null)
         // a is not the root
         if (a == pa.leftChild)
            pa.leftChild = b;
         else
            pa.rightChild = b;
      else
         root = b;
   
      // set balance factors
      ((AVLElement) ((Data) a.element).element).bf = 0;
      ((AVLElement) ((Data) b.element).element).bf = 0;
   }
   
   /** LR rotation around a, pa is parent of a and b is left child of a */
   void lrRotate(BinaryTreeNode pa, BinaryTreeNode a, BinaryTreeNode b)
   {
      BinaryTreeNode c = b.rightChild;
   
      // restructure subtree at a
      a.leftChild = c.rightChild;
      b.rightChild = c.leftChild;
      c.leftChild = b;
      c.rightChild = a;
      if (pa != null)
         // a is not the root
         if (a == pa.leftChild)
            pa.leftChild = c;
         else 
            pa.rightChild = c;
      else 
         root = c;
   
      // set balance factors
      int bfOfC = ((AVLElement) ((Data) c.element).element).bf;
      if (bfOfC == 1)
      {   
         ((AVLElement) ((Data) a.element).element).bf = -1;
         ((AVLElement) ((Data) b.element).element).bf = 0;
      }
      else
         if (bfOfC == -1)
         {
            ((AVLElement) ((Data) a.element).element).bf = 0;
            ((AVLElement) ((Data) b.element).element).bf = 1;
         }
         else
         {// bfOfC = 0
            ((AVLElement) ((Data) a.element).element).bf = 0;
            ((AVLElement) ((Data) b.element).element).bf = 0;
         }
      ((AVLElement) ((Data) c.element).element).bf = 0;
   }
   
   /** RL rotation around a, pa is parent of a and b is right child of a */
   void rlRotate(BinaryTreeNode pa, BinaryTreeNode a, BinaryTreeNode b)
   {
      BinaryTreeNode c = b.leftChild;
   
      // restructure subtree at a
      a.rightChild = c.leftChild;
      b.leftChild = c.rightChild;
      c.leftChild = a;
      c.rightChild = b;
      if (pa != null)
         // a is not the root
         if (a == pa.leftChild)
            pa.leftChild = c;
         else 
            pa.rightChild = c;
      else 
         root = c;
   
      // set balance factors
      int bfOfC = ((AVLElement) ((Data) c.element).element).bf;
      if (bfOfC == 1)
      {   
         ((AVLElement) ((Data) a.element).element).bf = 0;
         ((AVLElement) ((Data) b.element).element).bf = -1;
      }
      else
         if (bfOfC == -1)
         {
            ((AVLElement) ((Data) a.element).element).bf = 1;
            ((AVLElement) ((Data) b.element).element).bf = 0;
         }
         else
         {// bfOfC = 0
            ((AVLElement) ((Data) a.element).element).bf = 0;
            ((AVLElement) ((Data) b.element).element).bf = 0;
         }
      ((AVLElement) ((Data) c.element).element).bf = 0;
   }
   
   /** insert an element with the specified key
     * overwrite old element if there is already an
     * element with the given key 
     * @return old element (if any) with key = theKey */
   public Object put(Object theKey, Object theElement)
   {
      BinaryTreeNode p = root,     // search pointer
                     pp = null,    // parent of p
                     a = null,     // node with bf != 0
                     pa = null;    // parent of a

      // find place to insert theElement
      // also record most recent node with bf != 0
      // in a and its parent in pa
      Comparable elementKey = (Comparable) theKey;
      while (p != null)
      {// examine p.element.key
         Data pData = (Data) p.element;
         if (((AVLElement) pData.element).bf != 0)
         {// new candidate for a node
            a = p;
            pa = pp;
         }
         pp = p;
         // move p to a child
         if (elementKey.compareTo(pData.key) < 0)
            p = p.leftChild;
         else if (elementKey.compareTo(pData.key) > 0)
                 p = p.rightChild;
              else
              {// overwrite element with same key
                 Object elementToReturn = ((AVLElement) pData.element).element;
                 ((AVLElement) pData.element).element = theElement;
                 return elementToReturn;
              }
      }
   
      // get a node for theElement and attach to pp
      AVLElement q = new AVLElement(0, theElement);
      BinaryTreeNode r = new BinaryTreeNode
                             (new Data(elementKey, q));
      if (root != null)
         // the tree is not empty
         if (elementKey.compareTo(((Data) pp.element).key) < 0)
            pp.leftChild = r;
         else
            pp.rightChild = r;
      else
      {// insertion into empty tree
         root = r;
         return null;
      }
   
      // see if we must rebalance or simply change balance factors
      if (a != null)
      {// possible rebalancing needed
         Data aData = (Data) a.element;
         if (((AVLElement) aData.element).bf < 0)
            // bf = -1 before insertion
            if (elementKey.compareTo(aData.key) < 0)
            {// insertion in left subtree
               // height of left subtree has increased by 1
               // new bf of a is 0, no rebalancing
               ((AVLElement) aData.element).bf = 0;
               // fix bf on path from a to r
               fixBF(a.leftChild, r, elementKey);
            }
            else
            {// insertion in right subtree
               // bf of a is -2, rebalance
               BinaryTreeNode b = a.rightChild;
               if (elementKey.compareTo(((Data) b.element).key) > 0)
               {// RR case
                  fixBF(b.rightChild, r, elementKey);
                  rrRotate(pa, a, b);
               }
               else
               {// RL case
                  fixBF(b.leftChild, r, elementKey);
                  rlRotate(pa, a, b);
               }
            }
         else // bf = +1 before insertion
            if (elementKey.compareTo(aData.key) > 0)
            {// insertion in right subtree
               // height of right subtree has increased by 1
               // new bf of a is 0, no rebalancing
               ((AVLElement) aData.element).bf = 0;
               // fix bf on path from a to r
               fixBF(a.rightChild, r, elementKey);
            }
            else
            {// insertion in left subtree
               // bf of a is +2, rebalance
               BinaryTreeNode b = a.leftChild;
               if (elementKey.compareTo(((Data) b.element).key) < 0)
               {// LL case
                  fixBF(b.leftChild, r, elementKey);
                  llRotate(pa, a, b);
               }
               else
               {// LR case
                  fixBF(b.rightChild, r, elementKey);
                  lrRotate(pa, a, b);
               }
            }
      }
      else // a is null, no rebalancing
         fixBF(root, r, elementKey);

      return null;
   }
   
   /** @return matching element and remove it
     * @return null if no matching element */
   public Object remove(Object theKey)
   {
      Comparable searchKey = (Comparable) theKey;
   
      // define a stack to hold path taken from root
      // to physically deleted node
      ArrayStack stack = new ArrayStack();
   
      // p will eventually to point to node with key theKey
      BinaryTreeNode p = root; // search pointer
      while (p != null && !theKey.equals(((Data) p.element).key))
      {// move to a child of p
         stack.push(p);
         if (searchKey.compareTo(((Data) p.element).key) < 0)
            p = p.leftChild;
         else
            p = p.rightChild;
      }

      if (p == null)
         // no element with key theKey
         return null;
   
      // save element that will be removed
      Object theElement = ((AVLElement) ((Data) p.element).element).element;
   
      // restructure tree
      // handle case when p has two children
      if (p.leftChild != null && p.rightChild != null)
      {// p has two children, convert to 0 or 1 child case
         // find largest element in left subtree of p
         stack.push(p);
         BinaryTreeNode s = p.leftChild;
         while (s.rightChild != null)
         {// move to larger element
            stack.push(s);
            s = s.rightChild;
         }
   
         // move largest from s to p
         ((Data) p.element).key = ((Data) s.element).key;
         ((AVLElement) ((Data) p.element).element).element =
                ((AVLElement) ((Data) s.element).element).element;
         p = s;
      }
   
      // p has at most one child
      // save child pointer in c
      BinaryTreeNode c;
      if (p.leftChild != null)
         c = p.leftChild;
      else
         c = p.rightChild;
   
      // delete p
      if (p == root)
         root = c;
      else
         // is p a left or right child?
         if (p == ((BinaryTreeNode) stack.peek()).leftChild)
            ((BinaryTreeNode) stack.peek()).leftChild = c;
         else
            ((BinaryTreeNode) stack.peek()).rightChild = c;

      Comparable pKey = ((Data) p.element).key;
                // pKey may not equal theKey
   
      // rebalance tree and correct balance factors
      // use stack to retrace path to root
      // set q to parent of deleted node
      BinaryTreeNode q;
      try {q = (BinaryTreeNode) stack.pop();}
      catch (Exception e)
         {return theElement;}  // root was deleted
   
      while (q != null)
      {
         Data qData = (Data) q.element;
         AVLElement qAVL = (AVLElement) qData.element;
         if (pKey.compareTo(qData.key) <= 0)
         {// node p was deleted from the left subtree of q
            // height of left subtree reduced by 1
            qAVL.bf--;
            if (qAVL.bf == -1)
               // height of q is unchanged, nothing more to do
               return theElement;
            if (qAVL.bf == -2)
            {// q is unbalanced, classify unbalance and rotate
               BinaryTreeNode b = q.rightChild,
                              pa;  // q is a node
                                   // pa is parent of a
               try {pa = (BinaryTreeNode) stack.pop();}
               catch (Exception e)
                  {pa = null;}     // stack empty
               AVLElement bAVL = (AVLElement) ((Data) b.element).element;
               switch (bAVL.bf)
               {
                  case 0:           // L0 imbalance
                     rrRotate(pa, q, b);
                     bAVL.bf = 1;
                     qAVL.bf = -1;  // q is a node
                     return theElement;
                  case 1:           // L1 imbalance
                     rlRotate(pa, q, b);
                     break;         // must continue on path to root
                  case -1:          // L-1 imbalance
                     rrRotate(pa, q, b);
               }
               q = pa;
            }
            else
               // qAVL.bf is 0
               try {q = (BinaryTreeNode) stack.pop();}
               catch (Exception e)
                  {q = null;}     // stack empty
         }
         else
         {// pKey > qData.key
            // deleted from right subtree of q
            // height of right subtree reduced by 1
            qAVL.bf++;
            if (qAVL.bf == 1)
               // height of q is unchanged, nothing more to do
               return theElement;
            if (qAVL.bf == 2)
            {// q is unbalanced
               // classify imbalance and rotate
               BinaryTreeNode b = q.leftChild,
                              pa;  // q is a node
                                   // pa is parent of a
               try {pa = (BinaryTreeNode) stack.pop();}
               catch (Exception e)
                  {pa = null;}     // stack empty
               AVLElement bAVL = (AVLElement) ((Data) b.element).element;
               switch (bAVL.bf)
               {
                  case 0:                // R0 imbalance
                     llRotate(pa, q, b);
                     bAVL.bf = -1;
                     qAVL.bf = 1;        // q is a node
                     return theElement;
                  case 1:                // R1 imbalance
                     llRotate(pa, q, b);
                     break;              // must continue on path to root
                  case -1:               // R-1 imbalance
                     lrRotate(pa, q, b);
               }
               q = pa;
            }
            else
               // qAVL.bf is 0
               try {q = (BinaryTreeNode) stack.pop();}
               catch (Exception e)
                  {q = null;}     // stack empty
         }   
      }     
   
      return theElement;
   }

   // test AVL search tree class
   public static void main(String [] args)
   {
      AVLtree y = new AVLtree();

      // first test insert and ascending output
      y.put(new Integer(21), new Integer(21));
      y.put(new Integer(26), new Integer(26));
      y.put(new Integer(30), new Integer(30));
      System.out.println("An RR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // test LL rotation
      y.put(new Integer(9), new Integer(9));
      y.put(new Integer(4), new Integer(4));
      System.out.println("An LL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // test LR rotation
      y.put(new Integer(14), new Integer(14));
      System.out.println("An LR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // test RL rotation
      y.put(new Integer(28), new Integer(28));
      System.out.println("An RL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // another RL rotation
      y.put(new Integer(18), new Integer(18));
      y.put(new Integer(15), new Integer(15));
      System.out.println("An RL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // yet another RLrotation
      y.put(new Integer(10), new Integer(10));
      System.out.println("An RL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // an LL rotation
      y.put(new Integer(2), new Integer(2));
      System.out.println("An LL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // an LR rotation
      y.put(new Integer(3), new Integer(3));
      System.out.println("An LR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // another LR rotation
      y.put(new Integer(7), new Integer(7));
      System.out.println("An LR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // now test the delete operation
      // L0/RR rotation
      y.remove(new Integer(2));
      y.remove(new Integer(3));
      System.out.println("An L0/RR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // R-1/RR rotation
      y.remove(new Integer(10));
      System.out.println("An R-1/LR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // L-1/RR rotation
      y.remove(new Integer(18));
      y.remove(new Integer(4));
      y.remove(new Integer(9));
      System.out.println("An L-1/RR rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // L1/RL rotation
      y.remove(new Integer(30));
      y.remove(new Integer(14));
      y.remove(new Integer(7));
      y.remove(new Integer(15));
      System.out.println("An L1/RL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // several inserts
      y.put(new Integer(10), new Integer(10));
      y.put(new Integer(5), new Integer(5));
      y.put(new Integer(30), new Integer(30));
      y.put(new Integer(29), new Integer(29));
   
      // an R0/LL rotation
      y.remove(new Integer(29));
      y.remove(new Integer(28));
      y.remove(new Integer(30));
      System.out.println("An R0/LL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      // an R1/LL rotation
      y.put(new Integer(3), new Integer(3));
      y.remove(new Integer(26));
      y.remove(new Integer(21));
      System.out.println("An R1/LL rotation has been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
    
      // empty out and create larger tree
      y.remove(new Integer(5));
      y.remove(new Integer(3));
      y.remove(new Integer(10));
   
      y.put(new Integer(40), new Integer(40));
      y.put(new Integer(5), new Integer(5));
      y.put(new Integer(50), new Integer(50));
      y.put(new Integer(3), new Integer(3));
      y.put(new Integer(10), new Integer(10));
      y.put(new Integer(45), new Integer(45));
      y.put(new Integer(60), new Integer(60));
      y.put(new Integer(1), new Integer(1));
      y.put(new Integer(7), new Integer(7));
      y.put(new Integer(30), new Integer(30));
      y.put(new Integer(41), new Integer(41));
      y.put(new Integer(47), new Integer(47));
      y.put(new Integer(55), new Integer(55));
      y.put(new Integer(70), new Integer(70));
      y.put(new Integer(20), new Integer(20));
      y.put(new Integer(46), new Integer(46));
      y.put(new Integer(52), new Integer(52));
      y.put(new Integer(65), new Integer(65));
      y.put(new Integer(72), new Integer(72));
      y.put(new Integer(68), new Integer(68));
   
      // should cause multiple rotations
      y.remove(new Integer(3));
      System.out.println("Two L-1/RR rotations have been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   
      y.put(new Integer(58), new Integer(58));
      y.put(new Integer(56), new Integer(56));
      y.put(new Integer(74), new Integer(74));
      y.put(new Integer(71), new Integer(71));
      y.put(new Integer(75), new Integer(75));
   
      // should cause multiple rotations
      y.remove(new Integer(5));
      y.remove(new Integer(1));
      y.remove(new Integer(7));
      y.remove(new Integer(20));
      y.remove(new Integer(10));
      y.remove(new Integer(30));
      System.out.println("An L1/RL followed by two L-1/RR " + 
                         "rotations have been done");
      System.out.println("Elements in ascending order are");
      y.ascend();
      System.out.println();
      System.out.println("Elements in postorder order are");
      y.postOrderOutput();
      System.out.println();
   }
}
