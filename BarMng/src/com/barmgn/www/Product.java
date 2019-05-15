package com.barmgn.www;

import java.sql.Blob;

public class Product {
   private int pno,  price;
   private String pname, category, detail;
   private Blob image;
   
   public Product(int pno, String pname, int price, String category, String detail, Blob image) {
      super();
      this.pno = pno;
      this.price = price;
      this.pname = pname;
      this.category = category;
      this.detail = detail;
      this.image = image;
   }

   public Product() {
      // TODO Auto-generated constructor stub
   }

   public int getPno() {
      return pno;
   }

   public void setPno(int pno) {
      this.pno = pno;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getPname() {
      return pname;
   }

   public void setPname(String pname) {
      this.pname = pname;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public String getDetail() {
      return detail;
   }

   public void setDetail(String detail) {
      this.detail = detail;
   }

   public Blob getImage() {
      return image;
   }

   public void setImage(Blob image) {
      this.image = image;
   }

   @Override
   public String toString() {
      return pname + " " + price;
   }
   

}
