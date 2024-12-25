import 'package:flutter/material.dart';

class PrivateSearchBar extends StatelessWidget {
  final Function(String) onSearch; // Função para capturar a pesquisa

  const PrivateSearchBar({super.key, required this.onSearch});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16),
      child: Row(
        children: [
          // Campo de pesquisa
          Expanded(
            child: TextField(
              onChanged: onSearch, // Captura a entrada do usuário
              decoration: InputDecoration(
                hintText: 'Pesquise destinos...',
                prefixIcon: const Icon(Icons.search),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(8),
                ),
              ),
            ),
          ),
          const SizedBox(width: 10),

          // Botão de busca
          ElevatedButton(
            onPressed: () {
              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(
                  content: Text('Função de pesquisa em desenvolvimento!'),
                ),
              );
            },
            child: const Text('Buscar'),
          ),
        ],
      ),
    );
  }
}
