package hib;

import java.util.Objects;

public class Task {
    private int id;
    private Integer projId;
    private String name;
    private String description;
    private String pctComplete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPctComplete() {
        return pctComplete;
    }

    public void setPctComplete(String pctComplete) {
        this.pctComplete = pctComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(projId, task.projId) &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(pctComplete, task.pctComplete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projId, name, description, pctComplete);
    }
}
