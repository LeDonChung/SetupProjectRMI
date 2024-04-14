# Những thứ cần cài khi dùng eclipse
![image](https://github.com/LeDonChung/SetupProjectRMI/assets/105205800/30577df0-f6e9-4e34-850c-fe4b6443fb0a)
![image](https://github.com/LeDonChung/SetupProjectRMI/assets/105205800/b63fc477-92b1-454f-9abe-da439a4e1a6e)
![image](https://github.com/LeDonChung/SetupProjectRMI/assets/105205800/358f51c4-6aef-4898-8557-4d53df3eee01)

# SetupProjectRMI
# B1: Chuẩn bị CSDL(MSSQL): Xóa TLSv1
 ![image](https://github.com/LeDonChung/SetupProjectRMI/assets/105205800/b6c63379-1485-443e-a7d0-a931cd7612e7)

# B2: Tạo Project Server
-	Tạo với groupid: com.xxx.server
-	Tạo pakege: com.xxx.server / dao, impl / entities
-	Tạo class Server để sau này dùng
-	Import POM, Import META-INF trong src/main/java
-	Update Maven Project
# B3: Kiểm tra Tạo entity
-	 Tạo entity Person: ID, Name
-	Chỉnh sửa <property name="hibernate.hbm2ddl.auto" value="create-drop" />
-	Kết nối MSSQL
-	Hoàn thành kiểm tra
# B4: RMI: 
-	Viết 1 hàm findAll(): List<Person>
-	Kiểm tra bằng cách gọi trong server trước
-	Class entity implements Serializable
-	Class interface: extends Remote
-	Class impl: extends UnicastRemoteObject implements PersonDAO
-	Start Server với port: 23861
# B5: Tạo Project Client
-	Export Server: interface, entities
-	Tạo Client.java để call hàm findAll()

  Server
    ProductDAO productDAO = new ProductDAOImpl();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		OrderDAO orderDAO = new OrderDAOImpl();
		
		LocateRegistry.createRegistry(23861);
		
		Context context = new InitialContext();
		
		context.rebind(AppUtils.SERVER_URL + "productDAO", productDAO);
		context.rebind(AppUtils.SERVER_URL + "customerDAO", customerDAO);
		context.rebind(AppUtils.SERVER_URL + "orderDAO", orderDAO);
		
		System.out.println("Server is running on port: " + 23861);

  Client
  public static final String SERVER_URL = "rmi://LAPTOP-646QQPK1:23861/";

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		CustomerDAO customerDAO = (CustomerDAO) Naming.lookup(SERVER_URL + "customerDAO");
		System.out.println(customerDAO.getNumberCustomerByState());
	}


# Cách chọn test để chạy
![image](https://github.com/LeDonChung/SetupProjectRMI/assets/105205800/9910de65-503f-462b-9155-001179e9d8e8)
![image](https://github.com/LeDonChung/SetupProjectRMI/assets/105205800/83031b40-54a5-451b-96b8-6d50845805df)

