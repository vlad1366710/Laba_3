package ru.muzafarov.main;

import ru.muzafarov.binaryTree.BinaryTree;
import ru.muzafarov.geometry.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите задание (1-6) или 0 для выхода:");
            System.out.println("1. Задание 1.3");
            System.out.println("2. Задание 2.4");
            System.out.println("3. Задание 3.2");
            System.out.println("4. Задание 4.4");
            System.out.println("5. Задание 5.5");
            System.out.println("6. Задание 5.7");
            System.out.println("7. Задание 6.4");
            System.out.println("8. Задание 7.3");
            System.out.println("9. Задание 8.4");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {

                        System.out.println("Вы выбрали Задание 1.3");

                        Square square = new Square(new Point(5, 3), 23);
                        System.out.println(square);

                        Polyline polyline = square.getPolyline();
                        System.out.println("Длина ломаной: " + polyline.getLength());


                        Point lastPoint = polyline.getLastPoint();
                        lastPoint.shift(15 - lastPoint.getX(), 25 - lastPoint.getY());
                        System.out.println("Длина ломаной после сдвига последней точки: " + polyline.getLength());


                        double x = getDoubleInput(scanner, "Введите координату X для точки: ");
                        double y = getDoubleInput(scanner, "Введите координату Y для точки: ");
                        double sideLength = getDoubleInput(scanner, "Введите длину стороны квадрата: ");

                        Square square2 = new Square(new Point(x, y), sideLength);
                        System.out.println(square2);

                        Polyline polyline2 = square2.getPolyline();
                        System.out.println("Длина ломаной: " + polyline2.getLength());

                        Point lastPoint2 = polyline2.getLastPoint();
                        lastPoint2.shift(15 - lastPoint2.getX(), 25 - lastPoint2.getY());
                        System.out.println("Длина ломаной после сдвига последней точки: " + polyline2.getLength());


                        double newSideLength = getDoubleInput(scanner, "Введите новую длину стороны квадрата: ");
                        square2.setSideLength(newSideLength);
                        System.out.println("Квадрат после изменения стороны: " + square);

                        polyline2 = square2.getPolyline();
                        System.out.println("Новая длина ломаной: " + polyline2.getLength());

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Вы выбрали Задание 2.4");
                    BinaryTree tree = new BinaryTree();

                    tree.add(3);
                    tree.add(5);
                    tree.add(4);
                    tree.add(7);
                    tree.add(1);
                    tree.add(2);

                    System.out.println("Дерево: " + tree);

                    System.out.println("Содержит 7: " + tree.contains(7));
                    System.out.println("Содержит 20: " + tree.contains(20));

                    tree.remove(5);
                    System.out.println("После удаления 5: " + tree);

                    tree.remove(2);
                    System.out.println("После удаления 2: " + tree);

                    break;
                case 3:
                    System.out.println("Вы выбрали Задание 3.2");
                    Point[] points = {
                            new Point(0, 0),
                            new Point(0, 5),
                            new Point(5, 5),
                            new Point(5, 0)
                    };

                    ClosedPolyline closedPolyline = new ClosedPolyline(points);
                    System.out.println(closedPolyline);
                    System.out.println("Длина замкнутой ломаной: " + closedPolyline.getLength());

                    break;
                case 4:
                    System.out.println("Вы выбрали Задание 4.4");
                    Shape circle = new Circle(0, 0, 5);
                    Shape square1 = new Square(0, 0, 4);
                    Shape rectangle = new MyRectangle(0, 0, 4, 6);
                    Shape triangle = new Triangle(0, 0, 4, 0, 2, 3);

                    System.out.println(circle);
                    System.out.println("Площадь: " + circle.area());

                    System.out.println(square1);
                    System.out.println("Площадь: " + square1.area());

                    System.out.println(rectangle);
                    System.out.println("Площадь: " + rectangle.area());

                    System.out.println(triangle);
                    System.out.println("Площадь: " + triangle.area());

                    break;
                case 5:
                    System.out.println("Вы выбрали Задание 5.5");

                    int numberOfPoints = (int) getDoubleInput(scanner, "Введите количество точек для ломаной линии: ");

                    if (numberOfPoints < 2) {
                        System.out.println("Ломаная линия должна содержать как минимум 2 точки.");
                        return;
                    }

                    List<Point> points_5 = new ArrayList<>();

                    for (int i = 1; i <= numberOfPoints; i++) {
                        double x = getDoubleInput(scanner, "Введите x для точки p" + i + ": ");
                        double y = getDoubleInput(scanner, "Введите y для точки p" + i + ": ");
                        points_5.add(new Point(x, y));
                    }

                    double lineX1 = getDoubleInput(scanner, "Введите x для начала линии: ");
                    double lineY1 = getDoubleInput(scanner, "Введите y для начала линии: ");
                    double lineX2 = getDoubleInput(scanner, "Введите x для конца линии: ");
                    double lineY2 = getDoubleInput(scanner, "Введите y для конца линии: ");

                    Point lineStart = new Point(lineX1, lineY1);
                    Point lineEnd = new Point(lineX2, lineY2);

                    Polyline polyline = new Polyline(points_5.toArray(new Point[0]));
                    Line line = new Line(lineStart, lineEnd);


                    GeometryService[] shapes = {polyline, line};

                    double totalLength = LengthCalculator.calculateTotalLength(shapes);
                    System.out.println("Общая длина: " + totalLength);


                    break;
                case 6:
                    System.out.println("Вы выбрали Задание 5.7");
                    Square square = new Square(new Point(0, 0), 2);
                    System.out.println(square);
                    Point p1 = new Point(0, 0);
                    Point p2 = new Point(3, 4);
                    Point p3 = new Point(6, 8);

                    Line line1 = new Line(new Point(2, 0), new Point(2, 2));
                    System.out.println(line1);

                    Polyline polyline_6 = new Polyline(new Point[]{p1, p2, p3});
                    System.out.println("Ломанная "+polyline_6);

                    Triangle triangle_6 = new Triangle(0, 0, 4, 0, 2, 3);
                    System.out.println(triangle_6);


                    List<GeometryService> shapes1 = new ArrayList<>();
                    shapes1.add(square);
                    shapes1.add(line1);
                    shapes1.add(polyline_6);
                    shapes1.add(triangle_6);

                    Polyline mergedPolyline = PolygonalChainMerger.mergePolygonalChains(shapes1);
                    System.out.println("Объединенная ломаная линия: " + mergedPolyline);

                    break;
                case 7:
                    System.out.println("Вы выбрали Задание 6.4");
                    Point point1 = new Point(1.0, 2.0);
                    Point point2 = new Point(1.0, 2.0);
                    Point point3 = new Point(2.0, 3.0);

                    System.out.println("point1.equals(point2): " + point1.equals(point2));
                    System.out.println("point1.equals(point3): " + point1.equals(point3));
                    Point point11 = new Point(1.0, 2.0);
                    Point point22 = new Point(3.0, 4.0);
                    Point point33 = new Point(5.0, 6.0);
                    Point point4 = new Point(1.0, 2.0);

                    Polyline polyline1 = new Polyline(new Point[]{point11, point22, point33});
                    Polyline polyline2 = new Polyline(new Point[]{point11, point22, point33});
                    Polyline polyline3 = new Polyline(new Point[]{point33, point4, point33});

                    System.out.println("polyline1.equals(polyline2): " + polyline1.equals(polyline2));
                    System.out.println("polyline1.equals(polyline3): " + polyline1.equals(polyline3));

                    System.out.println("polyline1: " + polyline1);
                    System.out.println("polyline2: " + polyline2);
                    System.out.println("polyline3: " + polyline3);

                    break;
                case 8:

                    System.out.println("Вы выбрали Задание 7.3");
                    if (args.length < 2) {
                        System.out.println("Использование: java ru.muzafarov.main.Power <X> <Y>");
                        return;
                    }

                    String xStr = args[0];
                    String yStr = args[1];

                    double result = Power.power(xStr, yStr);
                    System.out.printf("Результат: %.2f%n", result);

                    break;

                case 9:
                    System.out.println("Вы выбрали Задание 8.4");
                    CloningPoint originalPoint = new CloningPoint(1.0, 2.0);
                    CloningPoint clonedPoint = (CloningPoint) originalPoint.clone();

                    System.out.println("Оригинальная точка: " + originalPoint);
                    System.out.println("Клонированная точка: " + clonedPoint);


                    originalPoint.shift(1.0, 1.0);
                    System.out.println("После сдвига оригинальной точки:");
                    System.out.println("Оригинальная точка: " + originalPoint);
                    System.out.println("Клонированная точка: " + clonedPoint);

                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }

    }


    public static double getDoubleInput(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                System.out.println("Пожалуйста, введите корректное число.");
                scanner.next();
            }
        }
        return value;
    }
}
