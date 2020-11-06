
package com.iot.ihouse.datasource;

import java.util.List;
import com.google.gson.annotations.Expose;
//TODO:Change Name
@SuppressWarnings("unused")
public class Sensor {

    @Expose
    private List<Object> attributes;
    @Expose
    private String desc;
    @Expose
    private String formula;
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String type;
    @Expose
    private String unit;
    @Expose
    private String uri;

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
