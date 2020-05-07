package com.sample.baran.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;

import java.util.Comparator;

public class OperatorsInAction {
    public static void main(String[] args) {

        Observable<Employee> source = Observable.just(new Employee(1, "A", 4.5), new Employee(6, "B", 5), new Employee(7, "D", 5), new Employee(90, "F", 2), new Employee(108, "X", 1));
        Predicate<Employee> employeeRatingPredicate = employee -> employee.getRating() > 4;
        Comparator<Employee> employeeRatingComparator = (employee1, employee2) -> Double.compare(employee1.getRating(), employee2.getRating());
        Function<Employee, String> employeeStringFunction = employee -> employee.getEmpName();
        source.filter(employeeRatingPredicate).sorted(employeeRatingComparator)
                .map(employeeStringFunction).take(2).subscribe(System.out::println);

//        source.filter(employeeRatingPredicate).sorted(employeeRatingComparator).map(employee -> employee.getEmpId())
//                .cast(Integer.class).take(2).subscribe(System.out::println);



        Observable<Integer> sourceOfExpenses = Observable.just(10,20,100,250);
        @NonNull BiFunction<Integer, Integer, Integer> sumOperation = (a, b) -> (a + b);
        System.out.println("Monthly expenses");
        sourceOfExpenses.scan(sumOperation).subscribe(System.out::println);

        System.out.println("Total expenses");
        sourceOfExpenses.reduce(sumOperation).subscribe(System.out::println);





    }
}

class Employee {
    private int empId;
    private String empName;
    private double rating;

    public Employee(int empId, String empName, double rating) {
        this.empId = empId;
        this.empName = empName;
        this.rating = rating;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
