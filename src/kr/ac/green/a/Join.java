package kr.ac.green.a;

class Join {
	private String id;
	private String name;
	private String pw;
	private String nickName;
	private boolean gender;

	public Join() {
	}

	public Join(String id, String name, String pw, String nickName, boolean gender) {
		setId(id);
		setName(name);
		setPw(pw);
		setNickName(nickName);
		setGender(gender);
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public void doJoin() {
		new Join("skdndnf", "±è¼ºÈÆ", "123qwe", "¶±¼ö", true);
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Join [id=" + id + ", name=" + name + ", pw=" + pw + ", nickName=" + nickName + ", gender=" + gender
				+ "]";
	}
}
