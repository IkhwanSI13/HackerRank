package dataStructure;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Inserting_aNode_Into_aSorted_DoublyLinkedList {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static  class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    static class DoublyLinkedListPrintHelper {
        public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }

    static class Result {

        /*
         * Complete the 'sortedInsert' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_DOUBLY_LINKED_LIST llist
         *  2. INTEGER data
         */

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         *     int data;
         *     DoublyLinkedListNode next;
         *     DoublyLinkedListNode prev;
         * }
         *
         */

        public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
            // Write your code here
            if (llist == null) {
                DoublyLinkedListNode result = new DoublyLinkedListNode(data);
                return result;
            }
            DoublyLinkedListNode node = llist;
            while (node != null) {
                if (node.data >= data) {
                    DoublyLinkedListNode result = new DoublyLinkedListNode(data);
                    result.prev = node.prev;
                    result.next = node;
                    node.prev = result;
                    if (result.prev == null) return result;
                    else {
                        result.prev.next = result;
                        return llist;
                    }
                }
                if (node.next == null) {
                    DoublyLinkedListNode result = new DoublyLinkedListNode(data);
                    node.next = result;
                    result.prev = node;
                    result.next = null;
                    return llist;
                }
                node = node.next;
            }
            return llist;
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathResult.path));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    DoublyLinkedList llist = new DoublyLinkedList();

                    int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                    IntStream.range(0, llistCount).forEach(i -> {
                        try {
                            int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                            llist.insertNode(llistItem);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });

                    int data = Integer.parseInt(bufferedReader.readLine().trim());

                    DoublyLinkedListNode llist1 = Result.sortedInsert(llist.head, data);

                    DoublyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
