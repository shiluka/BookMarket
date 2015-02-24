package bookrating.algorithm.sort.heapsort;

import bookrating.record.Record;
import bookrating.vendor.Vendor;

//Heap Sort Algorithm
public class HeapSort {

	private int heapSize;
	private int heapSizeVendor;

	private Vendor[] vendor;
	private Record[] record;

	public HeapSort(Vendor[] vendor) {
		this.vendor = vendor;
		calHeapSizeVendor();
	}

	public HeapSort(Record[] record) {
		this.record = record;
		calHeapSize();
	}

	// assume not entering same time
	public void minHeapify(int i) {
		int l, r, minimum;
		l = left(i);
		r = right(i);

		if (l < heapSize && record[l].getTime() > record[i].getTime())
			minimum = l;
		else
			minimum = i;
		if (r < heapSize && record[r].getTime() > record[minimum].getTime())
			minimum = r;
		if (minimum != i) {
			Record temp = record[i];
			record[i] = record[minimum];
			record[minimum] = temp;
			minHeapify(minimum);
		}
	}

	public void minHeapifyVendor(int i) {
		int l, r, minimum;
		l = left(i);
		r = right(i);

		if (l < heapSizeVendor
				&& vendor[l].getAggregateRate() < vendor[i].getAggregateRate())
			minimum = l;
		else
			minimum = i;
		if (r < heapSizeVendor
				&& vendor[r].getAggregateRate() < vendor[minimum]
						.getAggregateRate())
			minimum = r;
		if (minimum != i) {
			Vendor temp = vendor[i];
			vendor[i] = vendor[minimum];
			vendor[minimum] = temp;
			minHeapifyVendor(minimum);
		}
	}

	public void buildMinHeap() {
		for (int i = ((heapSize - 1) / 2); i >= 0; i--) {
			minHeapify(i);
		}
	}

	public void buildMinHeapVendor() {
		for (int i = ((heapSizeVendor - 1) / 2); i >= 0; i--) {
			minHeapifyVendor(i);
		}
	}

	public void heapSort() {
		buildMinHeap();
		for (int i = (heapSize - 1); i >= 1; i--) {
			Record temp = record[i];
			record[i] = record[0];
			record[0] = temp;
			heapSize--;
			minHeapify(0);
		}
	}

	public void heapSortVendor() {
		buildMinHeapVendor();
		for (int i = (heapSizeVendor - 1); i >= 1; i--) {
			Vendor temp = vendor[i];
			vendor[i] = vendor[0];
			vendor[0] = temp;
			heapSizeVendor--;
			minHeapifyVendor(0);
		}
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	public void calHeapSize() {
		int x = 0;
		for (int i = 0; i < record.length; i++) {
			if (record[i] == null)
				break;
			else
				x++;
		}
		heapSize = x;
	}

	public void calHeapSizeVendor() {
		int x = 0;
		for (int i = 0; i < vendor.length; i++) {
			if (vendor[i] == null)
				break;
			else
				x++;
		}
		heapSizeVendor = x;
	}

	public int getHeapSize() {
		return heapSize;
	}

}
