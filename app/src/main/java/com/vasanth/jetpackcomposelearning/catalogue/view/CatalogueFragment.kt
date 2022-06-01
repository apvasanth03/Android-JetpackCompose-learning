package com.vasanth.jetpackcomposelearning.catalogue.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vasanth.jetpackcomposelearning.catalogue.viewmodel.CatalogueViewModel

class CatalogueFragment : Fragment() {

    val viewModel: CatalogueViewModel by viewModels()

    // region Fragment Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )
            setContent {
                Text(text = "Hello world.")
            }
        }
    }
    // endregion
}
