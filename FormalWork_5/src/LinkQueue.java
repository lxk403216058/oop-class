public class LinkQueue<E> {
	// ��ջ�Ľڵ�
	public class Node<E> {
		E e;//����
		Node<E> next;

		public Node() {
		}

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}

	private Node front;// ����ͷ������ɾ��
	private Node rear;// ����β���������
	private int size; // ���е�ǰ����

	public LinkQueue() {
		front = null;
		rear = null;
	}

	// �п�
	public boolean empty() {
		return size == 0;
	}

	// ����
	public boolean add(E e) {
		if (empty()) { // �������Ϊ��
			front = new Node(e, null);// ֻ��һ���ڵ㣬front��rear��ָ��ýڵ�
			rear = front;
		} else {
			Node<E> newNode = new Node<E>(e, null);
			rear.next = newNode; // ��β�ڵ��nextָ�������Ľڵ�
			rear = newNode; // ���½ڵ���Ϊ�µ�β�ڵ�
		}
		size++;
		return true;
	}

	// ���ض���Ԫ�أ�����ɾ��
	public Node<E> peek() {
		if (empty()) {
			throw new RuntimeException("�ն����쳣��");
		} else {
			return front;
		}
	}

	// ����
	public Node<E> poll() {
		if (empty()) {
			throw new RuntimeException("�ն����쳣��");
		} else {
			Node<E> value = front; // �õ�����ͷԪ��
			front = front.next;// ��front����ָ��ԭ����ͷԪ�ص���һ��Ԫ��
			value.next = null; // �ͷ�ԭ����ͷԪ�ص�next����
			size--;
			return value;
		}
	}

	// ���г���
	public int length() {
		return size;
	}
	
}