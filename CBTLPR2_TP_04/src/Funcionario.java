/*
 Nome: Paulo Eduardo da Silva Pessoa
 Prontuário: CB303092x

 Nome: Geovanna Barros de Assunção
 Prontario: CB303271X
*/
public class Funcionario {
	private int cod_func;
	private double sal_func;
	private String nome_func;
	private String ds_cargo;
	
	public Funcionario() {
		super();
	}
	public Funcionario(int cod_func, double sal_func, String nome_func, String ds_cargo) {
		super();
		this.cod_func = cod_func;
		this.sal_func = sal_func;
		this.nome_func = nome_func;
		this.ds_cargo = ds_cargo;
	}
	public int getCod_func() {
		return cod_func;
	}
	public void setCod_func(int cod_func) {
		this.cod_func = cod_func;
	}
	public double getSal_func() {
		return sal_func;
	}
	public void setSal_func(double sal_func) {
		this.sal_func = sal_func;
	}
	public String getNome_func() {
		return nome_func;
	}
	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}
	public String getDs_cargo() {
		return ds_cargo;
	}
	public void setDds_cargo(String ds_cargo) {
		this.ds_cargo = ds_cargo;
	}
}
