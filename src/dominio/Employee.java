package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private long id;
    private long folio;
    private long noEmployee;
    private String name;
    private String address;
    private String department;
    private String branch;
    private AttentionPoint puntoAtencion;

    public Employee() {
    }

    public Employee(long id) {
        this.id = id;
    }

    public Employee(long id, long folio, long noEmployee, String name, String address, String department, String branch, AttentionPoint puntoAtencion) {
        this.id = id;
        this.folio = folio;
        this.noEmployee = noEmployee;
        this.name = name;
        this.address = address;
        this.department = department;
        this.branch = branch;
        this.puntoAtencion = puntoAtencion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
    }

    public long getNoEmployee() {
        return noEmployee;
    }

    public void setNoEmployee(long noEmployee) {
        this.noEmployee = noEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public AttentionPoint getPuntoAtencion() {
        return puntoAtencion;
    }

    public void setPuntoAtencion(AttentionPoint puntoAtencion) {
        this.puntoAtencion = puntoAtencion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return folio == employee.folio && noEmployee == employee.noEmployee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio, noEmployee);
    }
}
