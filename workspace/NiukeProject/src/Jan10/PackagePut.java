package Jan10;

public class PackagePut {

	public int maxW = Integer.MIN_VALUE; // �洢��������Ʒ�����������ֵ
	// cw ��ʾ��ǰ�Ѿ�װ��ȥ����Ʒ�������ͣ�i ��ʾ���쵽�ĸ���Ʒ�ˣ�
	// w ����������items ��ʾÿ����Ʒ��������n ��ʾ��Ʒ����
	// ���豳���ɳ������� 100����Ʒ���� 10����Ʒ�����洢������ a �У��ǿ����������ú�����
	// f(0, 0, a, 10, 100)
	public void f(int i, int cw, int[] items, int n, int w) {
	  if (cw == w || i == n) { // cw==w ��ʾװ���� ;i==n ��ʾ�Ѿ����������е���Ʒ
	    if (cw > maxW) maxW = cw;
	    return;
	  }
	  f(i+1, cw, items, n, w);
	  System.out.println(i+1+":"+cw);
	  if (cw + items[i] <= w) {// �Ѿ��������Ա������ܵ�������ʱ�򣬾Ͳ�Ҫ��װ��
	    f(i+1,cw + items[i], items, n, w);
	  }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10,10,15,20,20,40,45,50,50,60};
		new PackagePut().f(0, 0, a, 10, 100);
	}

}