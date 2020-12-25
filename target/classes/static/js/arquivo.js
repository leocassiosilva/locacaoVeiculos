$(document).ready(function() {
	var id;
	jQuery.ajax({
		type : "GET",
		url : "/veiculos/getTipo",
		data : {},
		success : function(dados) {
			$("#tipo").append('<option value="">Selecione</option>');
			for (var i = 0; i < dados.length; i++) {
				$("#tipo").append($('<option>', {
					value : dados[i].id_tipo,
					text : dados[i].nome
				}));
			}
		}
	}).done(function() {

	}).fail(function() {
		console.log("erro ajax");
	});

	$('#tipo').change(function() {
		id = $('#tipo').val();
		$("#marca").empty();
		jQuery.ajax({
			type : "GET",
			url : "/veiculos/getVeiculo/" + id,
			data : {},
			success : function(dados) {
				$("#marca").append('<option value="">Selecione</option>');
				for (var i = 0; i < dados.length; i++) {
					$("#marca").append($('<option>', {
						value : dados[i].id_marca,
						text : dados[i].nome
					}));
				}

			}
		}).done(function() {

		}).fail(function() {
			console.log("erro ajax");
		})

	});

	$('#marca').change(function() {

		var id_marca = $('#marca').val();
		console.log(id);
		console.log(id_marca);
		jQuery.ajax({
			type : "GET",
			url : "/veiculos/getVeiculoMarca/" + id + "&" + id_marca,
			data : {},
			success : function(dados) {

				console.log("id = " + dados.id);
				$('#tipoMarca').val(dados.id_tipo_marca);

			}
		}).done(function() {

		}).fail(function() {
			console.log("erro ajax");
		})

	});
});

$(document).ready(function() {
	var vendaMediaMensal = $("#veic").val();
	var resultado = vendaMediaMensal.split("=");

	$("#veiculo").val(resultado[1]);

	$("#veiculoId").val(resultado[1]);

});

$(document).ready(function() {
	const DAY = 24 * 60 * 60 * 1000;
	var data1 = new Date(2020, 11, 30);
	var data2 = new Date(2020, 11, 06);

	/* Formatando data de retirada */
	var ano = data1.getFullYear();
	var mes = data1.getMonth();
	var dia = data1.getDate();
	var dataFormatada = ano + "-" + mes + "-" + dia;
	$("#dataRetirada").val(dataFormatada);
	console.log(dataFormatada);

	/* Formartando data de entrega */
	var ano2 = data2.getFullYear();
	var mes2 = data2.getMonth();
	var dia2 = data2.getDate();

	var dataFormatada2 = dia2 + "/" + mes2 + "/" + ano2;
	$("#dataEntrega").val(dataFormatada2);
	console.log(dataFormatada2);

	var calcMlsdata1 = data1.getTime();
	var calcMlsdata2 = data2.getTime();
	var diferenca = calcMlsdata2 - calcMlsdata1;
	var qtdDias = diferenca / DAY;
	console.log(qtdDias);
	var array;
	var valorSeguro = 0;
	var valorFinal = 0;
	$("#diarias").text(qtdDias);
	var precoVeiculo = $('#preco').text();
	console.log(precoVeiculo);
	$('#seguro').change(function() {

		var valor = $('#seguro option:selected').val();
		var nome = $('#seguro option:selected').text();
		if (valor != "") {

			console.log(valor);
			console.log(nome);

			array = nome.split("R$");
			console.log(array[0]);
			valorSeguro = array[1];
			console.log(valorSeguro);
			$("#valorSeguro").text(valorSeguro);

			valorFinal = (precoVeiculo * qtdDias) + (valorSeguro * qtdDias);

			$("#valorLocacao").text(valorFinal);
			$("#valorTotal").val(valorFinal);
		} else {
			valorFinal = (precoVeiculo * qtdDias);
			valorSeguro = 0;
			$("#valorSeguro").text(valorSeguro);
			console.log(valorFinal);
			$("#valorLocacao").text(valorFinal);
			$("#valorTotal").val(valorFinal)

		}
	});

});