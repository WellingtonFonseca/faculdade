import 'package:flutter/material.dart';

// Seção de Texto
class TextSection extends StatelessWidget {
  const TextSection({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(32), // Espaçamento interno
      child: const Text(
        'Localizadas no coração do Oceano Índico, as Ilhas Maldivas são conhecidas '
        'por suas águas cristalinas, areias brancas e luxuosos resorts. É o destino '
        'ideal para quem busca relaxamento e aventura em um paraíso tropical.',
        style: TextStyle(fontSize: 16, height: 1.5),
        softWrap: true, // Permite que o texto quebre automaticamente
        textAlign: TextAlign.justify, // Alinhamento justificado
      ),
    );
  }
}
