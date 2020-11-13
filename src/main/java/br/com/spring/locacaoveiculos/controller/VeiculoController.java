package br.com.spring.locacaoveiculos.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import br.com.spring.locacaoveiculos.model.Arquivo;
import br.com.spring.locacaoveiculos.model.Categoria;
import br.com.spring.locacaoveiculos.model.Marca;
import br.com.spring.locacaoveiculos.model.Tipo;
import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.ArquivoService;
import br.com.spring.locacaoveiculos.service.CategoriaService;
import br.com.spring.locacaoveiculos.service.MarcaService;
import br.com.spring.locacaoveiculos.service.TipoService;
import br.com.spring.locacaoveiculos.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private TipoService tipoService;

	@Autowired
	private ArquivoService arquivoService;
	
	@Autowired
	private CategoriaService categoriaService;

	public static final String uploadingDir = System.getProperty("user.dir") + "/src/main/resources/static/img/";

	@GetMapping(value = "/newVeiculo")
	public String form(Veiculo veiculo) {
		return "veiculo/cadastroVeiculo";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvarVeiculo(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles, Veiculo veiculo) {

		veiculoService.save(veiculo);
		System.out.println(veiculo.getId());
		String dado = null;

		for (MultipartFile uploadedFile : uploadingFiles) {

			try {
				String data = formataDados();
				File file = new File(uploadingDir);
				String hahs = getSHA512(uploadedFile.getOriginalFilename());
				File arq = new File(file, uploadedFile.getOriginalFilename());
				File arq2 = new File(file, data + "_" + hahs + ".jpg");
				System.out.println("Renomedo:  -> New name: " + arq2);
				System.out.println("Renomedo: -> New name: " + arq);
				uploadedFile.transferTo(arq2);
 
				dado = ("\\img\\" + arq2.getName());
				System.out.println(dado);
				Arquivo aquivo1 = new Arquivo(dado, veiculo);

				arquivoService.save(aquivo1);

			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/veiculo/cadastrar";
	}

	

	/* Metodo para gerar a Hash */
	public static String getSHA512(String input) {

		String toReturn = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	/* Metodo para pegar data e horario do upload */
	public static String formataDados() {
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS");
		String dado = d.format(new Date());

		dado = dado.replaceAll("-", "");
		dado = dado.replaceAll(":", "");
		dado = dado.replaceAll("\\.", "");
		return dado;
	}

	@GetMapping(value = "/getVeiculo/{id}")
	@ResponseBody
	public List<Marca> relatorio(@PathVariable("id") Long id, Veiculo veiculo) {
		return marcaService.buscarMarcaPeloTipo(id);
	}

	@ModelAttribute("tipos")
	public List<Tipo> listaDeTipos() {
		// System.out.println("Ola" + "");
		return tipoService.buscarTodosTipos();
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Veiculo> veiculo = veiculoService.buscarTodos();
		System.out.println("123");
		
		model.addAttribute("veiculos", veiculo); 
		return "veiculo/lista";
	}
	
	
	@ModelAttribute("categorias")
	public List<Categoria> listaDeDepartamentos(){
		return categoriaService.buscarTodos();
	}

}
