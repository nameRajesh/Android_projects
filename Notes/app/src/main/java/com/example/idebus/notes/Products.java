package com.example.idebus.notes;

/**
 * Created by IDEBUS on 1/14/2018.
 */

public class Products {

    private int _id;
    private String _productname;

    public Products(){
    }

    public Products(String productname) {
        this._productname = productname;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productName(String _productname) {
        this._productname = _productname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (_id != products._id) return false;
        return _productname != null ? _productname.equals(products._productname) : products._productname == null;
    }

}

