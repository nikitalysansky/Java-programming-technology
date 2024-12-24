import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import java.io.File;

public class XMLTreeViewer extends JFrame {
    private JTree tree;

    public XMLTreeViewer(String filePath) {
        // Настройка окна
        setTitle("XML Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Парсинг XML и создание модели для JTree
        DefaultMutableTreeNode root = parseXML(filePath);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        // Создание JTree
        tree = new JTree(treeModel);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);

        setLocationRelativeTo(null); // Центрирование окна
    }

    private DefaultMutableTreeNode parseXML(String filePath) {
        try {
            // Чтение XML-файла
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            // Получение корневого элемента
            Element rootElement = doc.getDocumentElement();

            // Рекурсивное создание узлов дерева
            return createTreeNode(rootElement);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ошибка при чтении XML: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            return new DefaultMutableTreeNode("Ошибка загрузки файла");
        }
    }

    private DefaultMutableTreeNode createTreeNode(Node node) {
        // Создаем узел дерева для текущего XML-узла
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(node.getNodeName());

        // Если у узла есть текстовое содержимое, добавляем его
        String textContent = node.getTextContent().trim();
        if (!textContent.isEmpty() && node.getChildNodes().getLength() == 1) {
            treeNode.add(new DefaultMutableTreeNode(textContent));
        }

        // Рекурсивно обрабатываем дочерние узлы
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                treeNode.add(createTreeNode(child));
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {
        // Путь к XML-файлу
        String filePath = "example.xml";

        // Проверяем существование файла
        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "Файл " + filePath + " не найден.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Запуск интерфейса
        SwingUtilities.invokeLater(() -> {
            XMLTreeViewer viewer = new XMLTreeViewer(filePath);
            viewer.setVisible(true);
        });
    }
}
